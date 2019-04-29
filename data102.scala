package cn.data

import scala.collection.mutable.ArrayBuffer

/**
  * Scala 数组转 Java 的 List
  */
object data102 {
  def main(args: Array[String]): Unit = {
      val buffer = ArrayBuffer("1","2")
    import scala.collection.JavaConversions.bufferAsJavaList
    val builder = new ProcessBuilder(buffer)
    val unit = builder.command()
    println(s"unit = ${unit}")



  }
}
