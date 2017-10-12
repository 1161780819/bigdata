package com.yang.spark.streaming

import java.time.LocalDate

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by yang on 2017/10/12.
  * sparkstreaming读取hdfs文件
  */
object ReadHdfs {

  def main(args: Array[String]): Unit = {
    if (args.length < 2){
      System.err.println("please input the hdfs path!")
      System.exit(-1)
    }

    val sparkconf = new SparkConf().setAppName("read hdfs")
    val ssc = new StreamingContext(sparkconf,Seconds(10))

    val lines = ssc.textFileStream(args(0))

    val fname = args(1) + "/" + LocalDate.now().toString

    lines.repartition(1).saveAsTextFiles(fname)

    ssc.start()
    ssc.awaitTermination()
  }

}
