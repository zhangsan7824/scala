package cn.scala
import util.control.Breaks._

/**
  * Josephu 问题为：设编号为1， 2， … n的n个人围坐一圈，
  * 约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个
  * 人出列，它的下一位又从1开始报数，数到m的那个人又出
  * 列，依次类推，直到所有人出列为止，由此产生一个出队
  * 编号的序列。
  * 提示：用一个不带头结点的循环链表来处理Josephu 问题：
  * 先构成一个有n个结点的单循环链表，然后由k结点起从1开
  * 始计数，计到m时，对应结点从链表中删除，然后再从被
  * 删除结点的下一个结点又从1开始计数，直到最后一个结点
  * 从链表中删除算法结束。
  */
object josephu {
  def main(args: Array[String]): Unit = {
    //创建boy
    val boyGame = new BoyGame
    boyGame.addBoy(7)
    boyGame.showBoy()
    //测试
    boyGame.countBoy(4,3,7)
  }
}
class Boy(bNo:Int){
  val no:Int = bNo
  var next:Boy = null
}
class BoyGame{
  var first:Boy = new Boy(-1) // -1也可以替换成null
  //添加小孩，形成一个单向环形列表
  //nums表示有多少小孩
  def addBoy(nums:Int):Unit = {
    if (nums < 1) {
      println("nums值不正确")
      return
    }
    //形成环形列表时需要辅助指针
    var curBoy: Boy = null
    for (no <- 1 to nums) {
      val boy = new Boy(no)
      //如果第一小孩
      if (no == 1) {
        first = boy
        first.next = first //形成一个环形的链表
        curBoy = first
      } else {
        curBoy.next = boy
        boy.next = first
        curBoy = boy
      }
    }
  }
  //编写方法countboy，完成游戏
  /**
    *
    * @param startNo 从第几个人开始数
    * @param countNo 数几次
    * @param nums 一共有多少人
    *  思路分析:
    *  1.在first前面设计一个辅助指针（helper），将helper指针定位到first前面
    *  2.将first指针移动到startNo这个小孩 小孩的helper对应移动
    *  3.开始数countNo个数[helper和first会对应的移动]
    *  4.删除first指向的这个小孩节点
    */
  def countBoy(startNo:Int,countNo:Int,nums:Int): Unit ={
    //对参数进行判
    if (first.next == null || startNo < 1 || startNo > nums){
      println("参数输入有误")
      return
    }
    //1.在first前面设计一个辅助指针（helper），将helper指针定位到first前面
    var helper = first
    breakable {
      while (true) {
        if (helper.next == first) {
          break()
        }
        helper = helper.next
      }
    }
    //2.将first指针移动到startNo这个小孩 小孩的helper对应移动
    for (i <- 0 until startNo - 1) {
      first = first.next
      helper = helper.next
    }
    //3.开始数countNo个数[helper和first会对应的移动]
    breakable {
      while (true) {
        if (helper == first) {
          break()
        }
        for (i <- 0 until countNo - 1) {
          first = first.next
          helper = helper.next
        }
        //输出出圈人的信息
        printf("小孩%d出圈\n", first.no)
        //将first指向的节点删除
        first = first.next
        helper.next = first
      }
    }
    //当while结束，只有一个人
    printf("最后留在圈里的人%d\n",first.no)
  }
  def showBoy(): Unit = {
    if (first.next == null) {
      println("没有任何小孩")
      return
    }
    //因为first不能动，所以需要借助辅助指针
    var curBoy = first
    breakable {
      while (true) {
        printf("小孩的编号 %d\n",curBoy.no)
        if (curBoy .next == first) {
          break()
        }
        curBoy = curBoy.next //后移
      }
    }

  }
}