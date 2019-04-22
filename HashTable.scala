package cn.scala
import scala.io.StdIn
import util.control.Breaks._

/**
  * google公司的一个上机题:
  * 有一个公司,当有新的员工来报道时,要求将该员工的信息加入
  * (id,性别,年龄,住址..),当输入该员工的id时,要求查找到该员工的
  * 所有信息.
  * 要求:
  * 不使用数据库速度越快越好=>哈希表(散列)
  * 添加时，保证按照id从低到高插入 [课后思考：如果id不是从低到高插入，但
  * 要求各条链表仍是从低到高，怎么解决?]
  * 1) 使用链表来实现哈希表, 该链表不带表头
  * [即: 链表的第一个结点就存放雇员信息]
  * 2) 思路分析并画出示意图
  * 3) 代码实现[增删改查(显示所有员工， 按id查询)}
  *
  */
object HashTable {
  def main(args: Array[String]): Unit = {
      //创建hashtable
    val tble = new hashTble(7)
      var key = " "
     while (true){
       println("list:表示显示雇员")
       println("exit:表示退出")
       println("add:添加雇员")
       println("find:查找雇员")
       key = StdIn.readLine()
       key match {
         case "add" =>{
           println("输入id")
           val id = StdIn.readInt()
           println("输入名字")
           val name = StdIn.readLine()
           val emp = new Emp(id,name)
           tble.add(emp)
         }
         case "find" =>{
           println("需要查找的id")
           val id = StdIn.readInt()
           tble.findEmpById(id)
         }
         case "list" =>{
           tble.list()
         }
       }

     }
  }
}


//创建emp类
class Emp(eId:Int,eName:String){
  val id = eId
  var name = eName
  var next:Emp = null
}

//创建EmplinkedList
class EmpLinkedList{
  //头指针 head直接指向雇员
  var head:Emp = null
  //添加雇员方法
  def add(emp:Emp):Unit={
    //如果是第一个雇员
    if (head == null){
      head =emp
      return
    }
    //定义辅助指针
    var cur = head
    breakable {
      while (true) {
        if (cur.next == null) {
          break()
        }
        cur = cur.next
      }
    }
    //cur指向链表的最后
    cur.next = emp
  }
  //遍历链表
  def list(i:Int):Unit={
    if(head == null){
      println(s"链表第${i}是空")
      return
    }
    println(s"链表第${i}条信息为\t")
    var cur  = head
    breakable {
      while (true) {
        if (cur == null) {
          break()
        }
        printf(" => id=%d,name=%s\t", cur.id, cur.name)
        cur = cur.next
      }
      println()
    }
  }
  def findEmpById(id:Int):Emp={
    //遍历
    if (head ==null){
      println("链表为空,没有数据")
      return null
    }
    var cur = head

    breakable {
      while (true) {
        if (cur == null) {
          break()
        }
        if (cur.id == id) {

          break()
        }
        cur = cur.next
      }
    }
   return cur
  }
}
class hashTble(val size:Int){
  val empLinkedListArr:Array[EmpLinkedList] = new Array[EmpLinkedList](size)
  //初始化empLinkedListArr的各个元素
  for (i<- 0 until size){
    empLinkedListArr(i) = new EmpLinkedList
  }
  def add(emp:Emp):Unit={
    //得到该员工应该加入那条链表
    val empLinkedListNo = hashFun(emp.id)
    this.empLinkedListArr(empLinkedListNo).add(emp)
  }
  //遍历hash表
  def list():Unit={
    for (i<- 0 until size){
      empLinkedListArr(i).list(i)
    }
  }

  def findEmpById(id:Int):Unit={
    val empLinkedListNo = hashFun(id)
    val emp = this.empLinkedListArr(empLinkedListNo).findEmpById(id)
    if (emp!=null){
      printf(s"在第$empLinkedListNo 找到id=%d name= %s",id,emp.name)
    }else{
      println("没有找到id是 %d \n",id)
    }
  }
  //散列函数
  def hashFun(id:Int):Int={
    id % size
  }
}