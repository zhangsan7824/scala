package cn.scala
import util.control.Breaks._
object test {
  def main(args: Array[String]) {
    val node4 = new HerNode(4,"d","04")
    val node1 = new HerNode(1,"a","01")
    val node2 = new HerNode(2,"b","02")
    val node3 = new HerNode(3,"c","03")

    val sing = new SingleLinkedList
  /*  sing.add(node4)
    sing.add(node1)
    sing.add(node2)
    sing.add(node3)*/
   sing.add2(node1)
    sing.add2(node2)
    sing.add2(node4)
    sing.add2(node3)

    sing.list
  }
}

//定义单向列表，链表的无序插入
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
  //链表的有序插入
  def add2(herNode: HerNode):Unit= {
    var temp = head
    var flag = false //判断编号是否存在，默认不存在
    breakable {
      while (true) {
        if (temp.next == null) { //说明temp已经到了链表最后
          break()
        }
        if (temp.next.no < herNode.no) { //位置找到,当前节点加入到temp后
          break()

        } else if (temp.next.no == herNode.no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag){
      printf("插入对象已经存在",herNode.no)
    }else{
      herNode.next  = temp.next
      temp.next = herNode
    }
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
