package cn.scala
import java.text.SimpleDateFormat
import java.util.Date

/**
  * 
  * 排序前时间=2019-04-22 17:25:08
  * 排序后时间=2019-04-22 17:25:13
  */
object bubbleSort {
  def main(args: Array[String]): Unit = {
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

   // println(array.mkString(" "))
    println("排序后")
    bubblesort(array) //冒泡排序
    println(array.mkString(" "))
    val now1:Date = new Date()
    val date1 = dataFormat.format(now1)
    println("排序后时间="+date1)

  }
  def bubblesort(array: Array[Int]):Unit={
    for (i <- 0 until array.length - 1){
      for (j <- 0 until array.length - 1 - i){
            if (array(j)>array(j+1)){
              val temp = array(j)
              array(j) = array(j+1)
              array(j+1) = temp
            }
      }
    }
  }
}
