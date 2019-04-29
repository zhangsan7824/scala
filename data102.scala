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

  //Java 的 List 转 scala 的 Buffer

    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable
    val scalaArr: mutable.Buffer[String] = buffer
    scalaArr.append("jack")
    println(scalaArr)
    


  }
}
