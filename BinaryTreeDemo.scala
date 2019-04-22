package cn.scala

/**
  * 前序遍历: 先输出父节点，再遍历左子树和右子树
  * 中序遍历: 先遍历左子树， 再输出父节点，再遍历
  * 后序遍历: 先遍历左子树，再遍历右子树， 最后输出父节点
  */
object BinaryTreeDemo {
  def main(args: Array[String]): Unit = {
    val root = new HeroNode(1, "北京")
    val hero2 = new HeroNode(2, "上海")
    val hero3 = new HeroNode(3, "广州")
    val hero4 = new HeroNode(4, "深圳")
    val hero5 = new HeroNode(5, "天津")
    root.left = hero2
    root.right = hero3
    hero3.left = hero5
    hero3.right = hero4
    val binaryTree = new binaryTree
    binaryTree.root = root

    /*println("前序=================================")
    binaryTree.preOrder()*/
   /* println("中序=================================")
    binaryTree.infixOrder()*/
    println("后序=================================")
    binaryTree.postOrder()
  }
}
//定义节点
class HeroNode(hNo:Int,hName:String){
  val  no = hNo
  val name = hName
  var left:HeroNode = null
  var right:HeroNode = null
  //后序遍历
  def postOrder():Unit={
    //向左递归，输出左子树
    if (this.left!=null){
      this.left.postOrder()
    }
    //向右递归，输出右子树
    if (this.right!=null){
      this.right.postOrder()
    }

    //先输出当前节点的值
    printf("节点信息 no=%d name=%s\n",no,name)

  }
   //中序遍历
  def infixOrder():Unit={
    //向左递归，输出左子树
    if (this.left!=null){
      this.left.infixOrder()
    }
    //先输出当前节点的值
    printf("节点信息 no=%d name=%s\n",no,name)

    //向右递归，输出右子树
    if (this.right!=null){
      this.right.infixOrder()
    }
  }
  //前序遍历
  def preOrder():Unit={
    //先输出当前节点的值
    printf("节点信息 no=%d name=%s\n",no,name)
    //向左递归，输出左子树
    if (this.left!=null){
    this.left.preOrder()
    }
    //向右递归，输出右子树
    if (this.right!=null){
      this.right.preOrder()
    }
  }


}

class binaryTree{
  var root :HeroNode = null
  //后序
  def postOrder():Unit={
    if (root != null){
      root.postOrder()
    }else{
      println("当前二叉树是空的，不能遍历")
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

  //前序遍历
  def preOrder():Unit={
    if (root != null){
      root.preOrder()
    }else{
      println("当前二叉树是空的，不能遍历")
    }
  }

}