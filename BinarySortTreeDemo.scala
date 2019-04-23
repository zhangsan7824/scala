package cn.scala

/**
  * 创建和遍历:
  * 一个数组创建成对应的二叉排序树，并使用中序遍历二叉排序树，比如: 数组为
  * Array(7, 3, 10, 12, 5, 1, 9,2) 做成一个二叉排序树
  *
  *删除:
  * 二叉排序树的删除情况比较复杂，有下面三种情况需要考虑
  * 1) 删除叶子节点 (比如： 2, 5, 9, 12)
  * 2) 删除只有一颗子树的节点 (比如： 1)
  * 3) 删除有两颗子树的节点. (比如： 7, 3， 10 )
  */
object BinarySortTreeDemo {
  def main(args: Array[String]): Unit = {
   val arr = Array(7,3,10,12,5,1,9,2)
    //创建二叉排序树
    val tree = new BinarySortTree
    for (item <- arr){
      tree.add(new Node(item))
    }
    //遍历二叉排序树
    tree.infixOrder()

    //删除
   /* tree.delNode(2)
    tree.delNode(5)
    tree.delNode(9)
    tree.delNode(12)*/
    tree.delNode(7)
    println("删除后")
    tree.infixOrder()

  }
}



//定义节点
class Node(var value:Int){
  var left:Node = null
  var right:Node = null
//根据值查找节点
  def search(value: Int):Node = {
    //先判断当前是否是要删除节点
    if (value == this.value) {
      return this
    } else if (value < this.value) { //向左查找
      if (this.left == null) {
        return null
      } else {
        return this.left.search(value)
      }

    } else {
      if (this.right == null) {
        return null
      } else {
        return this.right.search(value)
      }
    }
  }

  //找个某个节点的父节点
  def searchParent(value:Int): Node = {
    //判断当前节点的左子节点和右子节点是否是这个值
    if ((this.left != null && this.left.value == value)||(this.right != null && this.right.value == value)){
      return this
    }else{
      if (this.left != null && value < this.value){  //向左边递归查找

           return this.left.searchParent(value)
      } else if (this.right != null && value > this.value){  //向右边递归查找

        return this.right.searchParent(value)
      }else{
        null
      }
    }

  }
  //添加方法
  def add(node:Node):Unit={
    if (node == null){
      return
    }
    //如果插入节点的值小于当前节点的值
    if(node.value < this.value){
      if (this.left == null){
        //该节点下没有左子节点,可以插入数据
        this.left = node
      }else{
        //递归进行插入
        this.left.add(node)
      }
    }else{ //如果插入节点的值不小于当前节点的值
      if (this.right == null){
        //该节点下没有左子节点,可以插入数据
        this.right = node
      }else{
        //递归进行插入
        this.right.add(node)
      }
    }
  }
  def infixOrder():Unit={
    //向左递归，输出左子树
    if (this.left!=null){
      this.left.infixOrder()
    }
    //先输出当前节点的值
    printf("节点信息 value=%d \n",value)

    //向右递归，输出右子树
    if (this.right!=null){
      this.right.infixOrder()
    }
  }
}
//定义二叉排序树
class BinarySortTree{
  var root:Node = null

  //删除某个右子树的最小值的节点，并返回最小值
  def delRightTreeMin(node:Node):Int = {
    var target = node
    //找最小值
    while (target.left != null){
      target = target.left
    }
    val minValue = target.value
     //删除最小值对应的节点
    delNode(minValue)
    return minValue
  }

  //查找节点
  def search(value: Int):Node = {
    if(root != null){
      return root.search(value)
    }else{
      return null
    }
  }
  //查找父节点
  def searchParent(value:Int):Node={
    if (root != null){
      return root.searchParent(value)

    }else{
      return null
    }
  }
  //删除节点 1) 删除叶子节点 (比如： 2, 5, 9, 12)
  def delNode(value:Int):Unit={
    if (root == null){
      return null

    }
    //先查看有没有该节点
    var targetNode = search(value)
    if (targetNode==null){ //该节点不存在直接返回
      return
    }
    //查找targetNode父节点
    var parentNode = searchParent(value)
    //1) 删除叶子节点 (比如： 2, 5, 9, 12)
    if (targetNode.left == null && targetNode.right == null){
      //判读删除的节点是targetNode的左子节点还是右子节点
      if(parentNode.left != null && parentNode.left.value == value){
        parentNode.left = null
      }else{
        parentNode.right = null
      }
    }else if (targetNode.left != null && targetNode.right != null){//argetNode只有2个子节点
      val value = delRightTreeMin(targetNode.right)
      targetNode.value = value
    }else{//targetNode只有一个子节点
      if (targetNode.left != null){//要删除的左子节点不能为空
        //判断targetNode 是parentNode的左子节点还是右子节点
        if (parentNode.left.value == value){
          parentNode.left = targetNode.left
        }else{
          parentNode.right = targetNode.left
        }
      }else{
        //判断targetNode 是parentNode的左子节点还是右子节点
        if (parentNode.left.value == value){
          parentNode.left = targetNode.right
        }else{
          parentNode.right = targetNode.right
        }
      }
    }
  }
  def add(node:Node):Unit={
    if (root == null){
      root = node
    }else{
      root.add(node)
    }
  }
  //中序
  def infixOrder():Unit={
    if (root != null){
      root.infixOrder()
    }else{
      println("当前二叉树是空的，不能遍历")
    }
  }
}