package cn.scala
import util.control.Breaks._
object calculator {
  def main(args: Array[String]): Unit = {
    /**要求：
      * 输入：30+3*6-2 得到30+3*6-2 = 46
      * 思路：
      * 1.设计两个栈，数字栈，符号栈
      * 2.对exp进行扫描。一个一个取出
      * 3.当取出的字符是数时，直接入栈
      * 4.当取出的字符是符号时：
      * 4.1如果当前符号栈没有数据，直接入栈
      * 4.2如果当前符号的优先级小于等于符号栈的栈顶的符号的优先级，则取出该符号，并从数字栈依次pop出两个数据，进行运算，
      * 并将结果重新push到数字栈，再将当前符号push到符号栈
      * 4.3 反之，符号入符号栈
      * 5.当整个表达书扫描完毕后，依次从数字栈和符号栈取出数据，进行运算，最后在数字栈的数据就是结果
      */
    val expression = "30+3*6-2"
    val numsstack = new ArrayStack2(10)
    val operstack = new ArrayStack2(10)
    var index = 0
    var num1 = 0
    var num2 = 0
    var oper = 0
    var res = 0
    var ch = ' '
    var keepNum = ""
    breakable{
    while (true) {
      ch = expression.substring(index, index + 1)(0)
      if (operstack.isOper(ch)) {
        //如果是操作符
        if (!operstack.isEmpty()) {
          if (operstack.priority(ch) <= operstack.priority(operstack.stack(operstack.top))) {
            //开始计算
            num1 = numsstack.pop().toString.toInt
            num2 = numsstack.pop().toString.toInt
            oper = operstack.pop().toString.toInt
            res = numsstack.cal(num1, num2, oper)
            //入栈
            numsstack.push(res)
            //入符号栈
            operstack.push(ch)
          } else {
            operstack.push(ch)
          }
        } else {
          operstack.push(ch)
        }
      } else {
        //处理多为数
        keepNum+=ch
        if (index == expression.length - 1){
          numsstack.push(keepNum.toInt)
        }else {


          if (operstack.isOper(expression.substring(index + 1, index + 2)(0))) {
            numsstack.push(keepNum.toInt)
            keepNum = ""
          }
        }
       // numsstack.push((ch + "").toInt)

      }
      //index 后移
      index += 1
      if (index >= expression.length()) {
        break()
      }
    }
  }
    breakable {
      while (true) {
        if (operstack.isEmpty()) {
          break()
        }
        num1 = numsstack.pop().toString.toInt
        num2 = numsstack.pop().toString.toInt
        oper = operstack.pop().toString.toInt
        res = numsstack.cal(num1, num2, oper)
        numsstack.push(res)
      }
    }
    val ress = numsstack.pop()
    printf("表达式 %s = %d",expression,ress)
  }
}
class  ArrayStack2(size:Int){
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
  //返回运算符的优先级
  def priority(oper:Int):Int={
    if (oper == '*' || oper=='/'){
      return 1
    }else if (oper=='+' || oper == '-'){
      return 0
    }else{
      -1
    }
  }
  def isOper(value:Int):Boolean ={
    value == '+' || value == '-' || value == '*' || value == '/'
  }
  def cal(num1: Int,num2:Int,oper:Int):Int={
    var res = 0
    oper match {
      case '+' =>{res = num1 + num2}
      case '-' =>{res = num2 - num1}
      case '*' =>{res = num1 * num2}
      case '/' =>{res = num2 / num1}
    }
    res
  }

}
