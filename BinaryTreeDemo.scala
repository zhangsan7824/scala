package cn.scala

/**
  * 前序遍历: 先输出父节点，再遍历左子树和右子树
  * 中序遍历: 先遍历左子树， 再输出父节点，再遍历右子树
  * 后序遍历: 先遍历左子树，再遍历右子树， 最后输出父节点
  *
  * 前序查找: 先对比父节点，再对比左子树和右子树
  * 中序查找: 先对比左子树， 再对比父节点，再对比右子树
  *  后序查找: 先对比左子树，再对比右子树， 最后对比父节点
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
   /* println("后序=================================")
    binaryTree.postOrder()*/
    /*val resNode = binaryTree.preOrderSearch(100)
    if (resNode!=null){
      printf("找到 编号=%d name=%s",resNode.no,resNode.name)
    }else{
      println("没有找到")
    }*/
    /*val resNode = binaryTree.infixOrderSearch(5)
   if (resNode!=null){
     printf("找到 编号=%d name=%s",resNode.no,resNode.name)
   }else{
     println("没有找到")
   }*/
 /*  val resNode = binaryTree.postOrderSearch(5)
    if (resNode!=null){
      printf("找到 编号=%d name=%s",resNode.no,resNode.name)
    }else{
      println("没有找到")
    }*/
    binaryTree.delNode(2)
    println("前序=================================")
   binaryTree.preOrder()
  }
}
//定义节点
class HeroNode(hNo:Int,hName:String){
  val  no = hNo
  val name = hName
  var left:HeroNode = null
  var right:HeroNode = null
  //删除节点
  //删除节点规则：
  //1.如果删除的节点是叶子节点，则删除该节点
  //2.如果删除的节点是非叶子节点，则删除该子树
  def delNode(no:Int):Unit={
    //比较当前节点的左子节点是否是要删除的节点
    if(this.left!=null && this.left.no == no){
      this.left = null
      return
    }
    //比较当前节点的右子节点是否是要删除的节点
    if(this.right!=null && this.right.no == no){
      this.right = null
      return
    }
    //向左递归删除
    if(this.left !=null){
      this.left.delNode(no)
    }
    //向右递归删除
    if(this.right!= null){
      this.right.delNode(no)
    }
  }


  //后序查找
  def postOrderSearch(no:Int):HeroNode={
    //左递归查找
    var resNode:HeroNode = null
    if (this.left!=null){
      resNode = this.left.postOrderSearch(no)
    }
    if (resNode!=null){
      return resNode
    }
    //向右边递归查找
    if (this.right!=null){
      resNode = this.right.postOrderSearch(no)
    }
    if (resNode!=null) {
      return resNode
    }
    println("=================")
    if (no == this.no){
      return this
    }

    resNode
  }
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
    println("=================")
    //中间
    if (no == this.no){
      return this
    }
    //先输出当前节点的值
    printf("节点信息 no=%d name=%s\n",no,name)

  }
  //中序查找
  def infixOrderSearch(no:Int):HeroNode={
    //左递归查找
    var resNode:HeroNode = null
    if (this.left!=null){
      resNode = this.left.infixOrderSearch(no)
    }
    if (resNode!=null){
      return resNode
    }
    println("=================")
    //中间
    if (no == this.no){
      return this
    }
    //向右边递归查找
    if (this.right!=null){
      resNode = this.right.infixOrderSearch(no)
    }
    return resNode


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
  //前序查找
  def preOrderSearch(no:Int):HeroNode={
    if (no == this.no){
      return this
    }
    //左递归查找
    var resNode:HeroNode = null
    if (this.left!=null){
      resNode = this.left.preOrderSearch(no)
    }
    if (resNode!=null){
      return resNode
    }
    //向右边递归查找
    if (this.right!=null){
      resNode = this.right.preOrderSearch(no)
    }
    return resNode
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
  def delNode(no:Int):Unit={
    if (root != null){
      //先判断root是不是当前要删除的节点
      if(root.no == no){
        root = null
      }else{
        root.delNode(no)
      }

    }
  }
  //后序查找
  def postOrderSearch(no:Int):HeroNode={
    if (root != null){
      root.postOrderSearch(no)
    }else{
      println("当前二叉树是空的，不能遍历")
      null
    }
  }
  //后序
  def postOrder():Unit={
    if (root != null){
      root.postOrder()
    }else{
      println("当前二叉树是空的，不能遍历")
    }
  }
  //中需查找
  def infixOrderSearch(no:Int):HeroNode={
    if (root != null){
      return root.infixOrderSearch(no)
    }else{
      //println("当前二叉树是空的，不能查找")
      return null
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
  //前序查找
def preOrderSearch(no:Int):HeroNode={
  if (root != null){
    return root.preOrderSearch(no)
  }else{
    //println("当前二叉树是空的，不能查找")
    return null
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