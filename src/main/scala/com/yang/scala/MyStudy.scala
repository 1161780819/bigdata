package com.yang.scala

/**
  * Created by yang on 2017/10/11.
  */
object MyStudy {

  def main(args: Array[String]): Unit = {
    print(test(2))
    val arr = Array(1,3,5)
    val arr1 = arr.map(a => println(a))
  }

  def test(a:Int) ={
    a * 2
  }

}
