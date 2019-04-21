package cn.scala
import scala.io.StdIn
object ArrayStackDemo {
  def main(args: Array[String]): Unit = {
    val arrayStack = new ArrayStack(4)
     var key = ""
    while (true){
      println("show:表示显示栈")
      println("exit:表示退出")
      println("push:添加数据到栈")
      println("pop:表示从栈取出数据")
      key = StdIn.readLine()
      key match {
        case "show" => arrayStack.list()
        case "push" => {
          println("输入数据")
          val value = StdIn.readInt()
          arrayStack.push(value)
        }
        case "pop" => {
          val res = arrayStack.pop()
          if (res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else{
            printf("取出数据 %d\n",res)
          }
        }
        case "exit" =>{
          System.exit(0)
        }
      }
    }
  }
}
class  ArrayStack(size:Int){
  //栈的大小
  val maxSize = size
  var stack = new Array[Int](maxSize)
  //初始化栈
  var top = -1
  //栈满
  def isFull():Boolean = {
    top == maxSize - 1
  }
  //栈空
  def isEmpty():Boolean = {
    top == -1
  }
  //入栈
  def push(value:Int):Unit={
     if (isFull()){
       println("栈满")
       return
     }
    top+=1
    stack(top) = value
  }
  //出栈
  def pop():Any={
    if (isEmpty()){
      return new Exception("栈空")
    }
    val value = stack(top)
    top -=1
    return value
  }
  def  list():Unit={
    if (isEmpty()){
      println("没有值")
      return
    }
    for (i<- 0 to top reverse){
      printf("stack[%d]=%d\n",i,stack(i))

    }
  }
}