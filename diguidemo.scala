
package cn.basis

object test04 {
  def main(args: Array[String]): Unit = {

        ddddd(4)
  }
  def ddddd(n:Int){
    if (n>2) {
      ddddd( n - 1)
    }
    println("n = "+ n)
  }
}
