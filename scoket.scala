package cn.scala

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time

object scoket {
     def main(args:Array[String]) {
          val port:Int = try {
             ParameterTool.fromArgs(args).getInt("port")
           } catch {
             case e:Exception => {
               print("获取失败，使用默认的端口")
             }
              9000
           }
            import org.apache.flink.api.scala._
             val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
             val text = env.socketTextStream("192.168.1.84",port,'\n')
             val wordcount = text.flatMap(_.split("\\s")).map(w=>line(w,1)).keyBy("word")
               .timeWindow(Time.seconds(2),Time.seconds(1))
               .sum("count")
              wordcount.print().setParallelism(1)
              env.execute("socketworldcount")

         }
  case  class line(word: String, count: Int)

}
