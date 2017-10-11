package com.yang.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yang on 2017/10/11.
  * spark程序读取hdfs文件
  */
object SparkReadHdfs {

  def main(args: Array[String]): Unit = {
    if (args.length < 1){
      System.err.println("please infput the hdfs file path!")
      System.exit(-1)
    }

    val sparkconf = new SparkConf().setAppName("ReadHdfs")
    val sc = new SparkContext(sparkconf)
    val file = sc.textFile(args(0))
    println("count=====" + file.count())
    println("first=====" + file.first())
  }

}
