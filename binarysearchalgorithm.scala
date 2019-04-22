package cn.scala

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._
/**
  * 二分查找必须基于有序的数组，否则找不到
  * 二分查找思路:
  * 1,先找中间值
  * 2.然后将查找值和中间值比较
  * 2.1相等，找出
  * 2.2 中间值 大于 查找值，向左递归查找
  * 2.23中间值 小于 查找值，向右递归查找
  */
object binarysearchalgorithm {
  def main(args: Array[String]): Unit = {
    val array = Array(1,99,99,99,99,99,22)
    /*val index = Binarysearch(array,0,array.length-1,100)
   if (index != -1){
     println("找到,下标是:" + index)
   }else{
     println("找不到")
   }*/
    var resArr = Binarysearch2(array,0,array.length-1,99)
     resArr = resArr.sortBy((x:Int)=>x)
    if (resArr.length!=0){
      for (index <- resArr){
        println("找到索引"+ index)
      }
    }else{
      println("没有找到")
    }
  }
  //如果存在值，就返回下标，否则返回-1
  def Binarysearch(array: Array[Int],l:Int,r:Int,findval:Int):Int={
    if (l > r){return -1}  //找不到
    val midIndex = (l+r)/2
    val midval = array(midIndex)
    if (midval > findval){
      Binarysearch(array,l,midIndex-1,findval)
    }else if (midval < findval){
      Binarysearch(array,midIndex+1,r,findval)
    }else{
      return midIndex
    }
  }

  /**
    *说明: val array = Array(1,22,99,99)
    * 通过Binarysearch2(array,0,array.length-1,99)方法
    * 得到:找到索引2
    *      找到索引3
    */

  def Binarysearch2(array: Array[Int],l:Int,r:Int,findval:Int):ArrayBuffer[Int]={
    if (l > r){return  ArrayBuffer()}  //找不到
    val midIndex = (l+r)/2
    val midval = array(midIndex)
    if (midval > findval){
      Binarysearch2(array,l,midIndex-1,findval)
    }else if (midval < findval){
      Binarysearch2(array,midIndex+1,r,findval)
    }else{
      //return midIndex
      val  resArr = ArrayBuffer[Int]() //定义可变数组
      //左边扫描
      var temp = midIndex -1
      breakable {
        while (true) {
          if (temp < 0 || array(temp) != findval) {
            break()
          }
          if (array(temp) == findval) {
            resArr.append(temp)
          }
          temp -= 1
        }
      }
      resArr.append(midIndex) //中间扫描
      temp = midIndex +1
      breakable {
        while (true) {
          if (temp > array.length-1 || array(temp) != findval) {
            break()
          }
          if (array(temp) == findval) {
            resArr.append(temp)
          }
          temp += 1
        }
      }
      return resArr
    }
  }
}
