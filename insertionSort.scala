package cn.scala

import java.text.SimpleDateFormat
import java.util.Date

/**
  *插入排序
  * 排序前
  * 排序前时间=2019-04-22 18:46:43
  * 排序后
  * 排序后时间=2019-04-22 18:46:46
  */
object insertionSort {
  def main(args: Array[String]): Unit = {
    //val array = Array(101,1,22,1000,200,2710)
    val random = new util.Random()
    val array = new Array[Int](80000)
    for(i <- 0 until 80000){   //循环生成随机数
      array(i) = random.nextInt(8000000)
    }
    println("排序前")
    val now:Date = new Date()
    val dataFormat:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dataFormat.format(now)
    println("排序前时间="+ date)

    insertSort(array)
    println("排序后")
    val now1:Date = new Date()
    val date1 = dataFormat.format(now1)
    println("排序后时间="+date1)
    println(array.mkString(" "))
    /*for (i <- 1 until array.length){

      val insertvalue = array(i)
      var insertIndex = i-1   //有序表最后一位的下标
      //还没有找到位置
      while (insertIndex >= 0 && insertvalue < array(insertIndex)){
        array(insertIndex+1) = array(insertIndex)
        insertIndex -=1
      }
      //退出循环，插入位置的就会找到了
      array(insertIndex+1) = insertvalue
      println(s"第${i}轮的结果是")
      println(array.mkString(" "))
    }
*/
  }
  def insertSort(array: Array[Int]):Unit={
    for (i <- 1 until array.length){
      //第一轮
      val insertvalue = array(i)
      var insertIndex = i-1   //有序表最后一位的下标
      //还没有找到位置
      while (insertIndex >= 0 && insertvalue < array(insertIndex)){
        array(insertIndex+1) = array(insertIndex)
        insertIndex -=1
      }
      //退出循环，插入位置的就会找到了
      array(insertIndex+1) = insertvalue
     /* println(s"第${i}轮的结果是")
      println(array.mkString(" "))*/
    }
  }
}
