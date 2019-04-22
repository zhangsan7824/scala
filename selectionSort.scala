package cn.scala
import java.text.SimpleDateFormat
import java.util.Date

/**
  * 排序前
  * 排序前时间=2019-04-22 18:08:03
  * 排序后
  * 排序后时间=2019-04-22 18:08:07
  */
object selectionSort {
  def main(args: Array[String]): Unit = {
   // val array = Array(101,1,22,1000)
   val random = new util.Random()
    val array = new Array[Int](80000)
    for(i <- 0 until 8){   //循环生成随机数
      array(i) = random.nextInt(8000000)
    }
    println("排序前")
    val now:Date = new Date()
    val dataFormat:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dataFormat.format(now)
    println("排序前时间="+ date)

   selectionsort(array)
    println("排序后")
    val now1:Date = new Date()
    val date1 = dataFormat.format(now1)
    println("排序后时间="+date1)
    //println(array.mkString(" "))
  /*  //第二轮
     min = array(1)
     minIndex = 1
    //遍历
    for (j <- 1+1 until array.length){
      if (min > array(j)){  //说明min不是最小值
        min = array(j)
        minIndex = j
      }
    }
    //判断是否需要交换
    if (minIndex != 1){
      array(minIndex) = array(1)
      array(1) = min
    }
    println("第二轮结束")
    println(array.mkString(" "))*/
  }
  def selectionsort(array: Array[Int]):Unit={
    for (i <- 0 until array.length -1) {
      //第一轮
      var min = array(i)
      var minIndex = i
      //遍历
      for (j <- (i+1) until array.length) {
        if (min > array(j)) { //说明min不是最小值
          min = array(j)
          minIndex = j
        }
      }
      //判断是否需要交换
      if (minIndex != i) {
        array(minIndex) = array(i)
        array(i) = min
      }
      //println("第二轮结束")
      //println(array.mkString(" "))
    }
  }
}
