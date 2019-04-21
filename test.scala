package cn.scala
import util.control.Breaks._
object test {
  def main(args: Array[String]) {
    val node1 = new HerNode(1,"a","01")
    val node2 = new HerNode(2,"b","02")
    val node3 = new HerNode(3,"c","03")
    val sing = new SingleLinkedList
    sing.add(node1)
    sing.add(node2)
    sing.add(node3)
    sing.list()
  }
}

//定义单向列表
class SingleLinkedList {
  //初始化头结点，头结点一般不动
   val head = new HerNode(0,"","")
  //编写添加的方法
  def add(herNode: HerNode):Unit={
    var temp = head
    breakable {
      while (true) {
        if (temp.next == null) {
          break()
        }
        temp = temp.next
      }
    }
     temp.next = herNode
  }
  //遍历单向列表
  def list():Unit = {
    if (head.next == null){
      print("链表为空")
      return
    }
    var temp = head.next
    breakable {
      while (true) {
        if (temp == null) {
          break()
        }
        println("节点信息：", temp.no, temp.name, temp.nickname)

        temp = temp.next
      }
    }
  }
}


class HerNode(hno: Int, hname: String, hnickname: String) {
  val no: Int = hno
  val name: String = hname
  val nickname: String = hnickname
  var next: HerNode = null
}