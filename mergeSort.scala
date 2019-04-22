package cn.scala

import java.text.SimpleDateFormat
import java.util.Date
/**  归并排序
*排序前
*排序前时间=2019-04-22 20:37:21
*快排后
*排序后时间=2019-04-22 20:37:37

*/
object mergeSort {
  def main(args: Array[String]): Unit = {
    //val array = Array(101,1,22,10,-2,0)

    val random = new util.Random()
    val array = new Array[Int](80000000)
    for(i <- 0 until 80000000){   //循环生成随机数
      array(i) = random.nextInt(8000000)
    }
    println("排序前")
    val now:Date = new Date()
    val dataFormat:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dataFormat.format(now)
    val temp = new Array[Int](array.length)
    println("排序前时间="+ date)

    MergeSort(array,0,array.length-1,temp)
    println("快排后")
    val now1:Date = new Date()
    val date1 = dataFormat.format(now1)
    println("排序后时间="+date1)
    //println(array.mkString(" "))
  }


  /**
    *
    * @param array  待排序的数组
    * @param left   最初左边的下标0
    * @param right  最初的右边下标 length-1
    * @param temp  临时数组,事先就开辟好的，大小和array一样
    */
  def MergeSort(array: Array[Int],left: Int,right: Int,temp:Array[Int]):Unit={
    if (left < right){
      val mid = (left+right)/2
      MergeSort(array,left,mid,temp) //递归将左边的数据做成有序列表
      MergeSort(array,mid+1,right,temp)  //递归将右边的数据做成有序列表
      merge(array,left,mid,right,temp)  //合并
    }
  }
  def merge(array: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]): Unit = {
    var i = left //左边的下标
    var j = mid + 1  //右边的指针
    var  t = 0  //temp数组的索引
    while (i <= mid && j <= right) {
      if (array(i) <= array(j)){  //如果是当前的左边的有序列表的值小于当前的右边的有序列表的值，就把这个值拷贝到temp
        temp(t) = array(i)
        t += 1
        i += 1
      }else{   //如果是当前的右边的有序列表的值小于当前的左边有序列表的值，就把这个值拷贝到temp数组
        temp(t) = array(j)
        t += 1
        j += 1
      }
    }
    while (i <= mid ) { //如果最左边的有序列表还有剩余数据，就依次拷贝到temp数组
        temp(t) = array(i)
        t += 1
        i += 1
    }
    while (j <= mid ) { //如果最右边的有序列表还有剩余数据，就依次拷贝到temp数组
      temp(t) = array(j)
      t += 1
      j += 1
    }
    //将temp的数据拷贝到array中
    t = 0
    var templeft = left
    while (templeft <= right){
      array(templeft) = temp(t)
      t += 1
      templeft += 1
    }
  }

}
