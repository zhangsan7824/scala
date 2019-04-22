package cn.scala

object diguidemo {
  def main(args: Array[String]): Unit = {
    test(4)

  }
  def test(n:Int): Unit={
    if (n>2){
      test(n-1)
    }
      println("n=" + n)

  }

}
