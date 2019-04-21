package cn.scala
import util.control.Breaks._

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