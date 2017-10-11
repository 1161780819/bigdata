package com.yang.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yang on 2017/10/11.
  */
object SparkWordCount {
  def main(args: Array[String]): Unit = {
    if (args.length < 2){
      System.err.println("please infput the hdfs file path!")
      System.exit(-1)
    }

    val sparkconf = new SparkConf().setAppName("ReadHdfs")
    val sc = new SparkContext(sparkconf)

    val file = sc.textFile(args(0))
    val words = file.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _)

    words.repartition(1).saveAsTextFile(args(1))

    sc.stop()
  }
}
