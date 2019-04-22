package cn.scala
import java.text.SimpleDateFormat
import java.util.Date
import util.control.Breaks._


/**
  * 快速排序
  * 排序前
  * 排序前时间=2019-04-22 19:35:51
  * 排序后
  * 排序后时间=2019-04-22 19:35:51
  */
object quicksort {
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

    QuickSort(0,array.length-1,array)
    val now1:Date = new Date()
    val date1 = dataFormat.format(now1)
    println("排序后")
    println("排序后时间="+date1)

    //println(array.mkString(" "))
  }

  /**
    *
    * @param left   指定数组左边的下标0
    * @param right   指定数组右边的下标 length -1
    * @param array   进行排序的数组
    */
  def QuickSort(left: Int,right: Int,array: Array[Int]):Unit={
    var l = left //左下标
    var r = right  //右下标
    var pivot = array((left+right)/2) //以中间的值为基准进行分割
    var temp = 0
    breakable{
       while (l < r ){ //while语句的作用是把pivot小的数放到左边，比pivot小的数放在右边
         while (array(l) < pivot){l+=1}  //从左边找一个比 pivot大的值对应下标
         while (array(r) > pivot){r-=1}  //从右边找一个比pivot小的值对应下标
         if (l>=r){break()} //说明本次交换结束
         var temp = array(l) //交换
         array(l) = array(r)
         array(r) = temp
         if (array(1) == pivot){r-=1} //处理后，发现array(l) ==pivot 就r-=1,提高效率
         if ((array(r)) == pivot){l += 1}
       }
    }
    if (l == r){ //提高效率
      l+=1
      r-=1
    }
    if (left < r){  //左递归排序
      QuickSort(left,r,array)
    }
    if (right > l){ //右递归排序
      QuickSort(l,right,array)
    }
  }
}
