package cn.scala

/**
  * 1 1 1 1 1 1 1
  * 1 0 0 0 0 0 1
  * 1 0 0 0 0 0 1
  * 1 1 1 0 0 0 1
  * 1 0 0 0 0 0 1
  * 1 0 0 0 0 0 1
  * 1 0 0 0 0 0 1
  * 1 1 1 1 1 1 1
  * 求坐标（2,2）到（6,7）策略
  *
  * 说明:
  * 1) 小球得到的路径，和程序员
  * 设置的找路策略有关即：找
  * 路的上下左右的顺序相关
  * 2) 再得到小球路径时，可以先
  * 使用(下右上左)，再改成(上
  * 右下左)， 看看路径是不是有变化
  * 3) 测试回溯现象
  * 4) 思考: 如何求出最短路径?
  * 思路：
  * 1.创建一个二维数组
  * 2.约定元素的值是0,：可以走，但还没有走，1：表示墙 2：表示可以走 3：表示已经走过，是死路
  * 3.确定一个策略：下右上左
  */
object MazeGame {
  def main(args: Array[String]): Unit = {
    //地图
    val map = Array.ofDim[Int](8,7)
    //上面全部值1
    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
    }
    //左右全部值1
    for (i <- 0 until 8){
      map(i)(0) = 1
      map(i)(6) = 1
    }
    //设置挡板
    map(3)(1) = 1
    map(3)(2) = 1
    //回溯
    //map(1)(2) = 1
    //map(2)(2) = 1
    //打印地图
    for (i <- 0 until 8){
      for (j <- 0 until 7){
        print(map(i)(j) + " ")
      }
      println()
    }
    setWay(map,1,1)
    println()
    for (i <- 0 until 8){
      for (j <- 0 until 7){
        print(map(i)(j) + " ")
      }
      println()
    }
  }

//使用递归回溯找路
  //1.map 表示地图
  //2. i j 表示从地图的什么位置开始找
  //.约定元素的值是0,：可以走，但还没有走，1：表示墙 2：表示可以走 3：表示已经走过，是死路
  def setWay(map: Array[Array[Int]],i:Int,j:Int):Boolean={
    if (map(6)(5) == 2){ //表示已经找到
      return true
    }else{
      if (map(i)(j) == 0){
        //开始递归回溯
        map(i)(j) =2 //默认可以走，能不能走不知道
        if (setWay(map,i+1,j)){ //下找
          return true
        }else if(setWay(map,i,j+1)) { //右
          return true
        }else if (setWay(map,i-1,j)){ //上
          return true
        }else if(setWay(map,i,j-1)){ //左
          return true
        }else{
          //走不通
          map(i)(j) =3
          return false
        }
      }else{
        return false
      }
    }
  }
}
