package cn.scala

import scala.util.control.Breaks._

object DoubleLinkedList {
   def main(args:Array[String]) {
     val node4 = new HerNode2(4,"d","04")
     val node1 = new HerNode2(1,"a","01")
     val node2 = new HerNode2(2,"b","02")
     val node3 = new HerNode2(3,"c","03")

     val sing = new DoubleLinkedList
     sing.add(node4)
     sing.add(node1)
     sing.add(node2)
     sing.add(node3)
     sing.list()
     val node5 = new HerNode2(3,"卢俊义","玉麒麟")
        sing.update(node5)
     println("==================================")
     sing.list()


     sing.del(4)
     println("删除后")
     sing.list()

       }
}

class DoubleLinkedList{
  //初始化头结点，头结点一般不动
  val head = new HerNode2(0,"","")

  //删除节点,因为双向链表可以实现自我删除
  def  del(no:Int):Unit={
    //
    var temp = head
    var flag = false
    breakable {
      while (true) {
        if (temp== null) {
          break()
        }
        if (temp.no == no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag){
      //temp.next = temp.next.next
      temp.pre.next = temp.next
      if (temp.next!=null) {
        temp.next.pre = temp.pre
      }
    }else{
      printf("节点不存在")
    }
  }
  //更新节点的值
  def update(newHeroNode:HerNode2):Unit= {
    //先找到节点
    if (head.next == null) {
      println("链表为kong")
      return
    }
    var temp = head.next
    var flag = false
    breakable {
      while (true) {
        if (temp == null) {
          break()
        }
        if (temp.no == newHeroNode.no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      temp.name = newHeroNode.name
      temp.nickname = newHeroNode.nickname
    } else {
      printf("没有找到节点")
    }

  }
  //添加add
  def add(herNode: HerNode2): Unit = {
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
    herNode.pre  = temp
  }
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

class HerNode2(hno: Int, hname: String, hnickname: String) {
  val no: Int = hno
  var name: String = hname
  var nickname: String = hnickname
  var pre: HerNode2 = null
  var next: HerNode2 = null
}
