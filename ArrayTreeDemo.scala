package cn.scala

/**
  * 给你一个数组 Array(1,2,3,4,5,6,7)，要求以二叉树前序遍历的方式进行遍
  * 历。 前序遍历的结果应当为 1,2,4,5,3,6,
  */
object ArrayTreeDemo {
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3,4,5,6,7)
    val arrayTree = new ArrayTree(array)
    //前序遍历数组
    arrayTree.preOrder()
  }
}
class ArrayTree(val array: Array[Int]){
  //对preOrder 进行重载
  def preOrder():Unit={
    this.preOrder(0)
  }
  def preOrder(index:Int):Unit={
    if (array ==null || array.length ==0){
      println("数组是空的，不能按照二叉树前序遍历")
    }
    println(array(index))
    //向左递归遍历
    if ((index * 2 +1) < array.length){
      preOrder(index * 2 + 1)
    }
    //向右边递归遍历
    if ((index * 2 +2) < array.length){
      preOrder(index * 2 +2)
    }
  }

}