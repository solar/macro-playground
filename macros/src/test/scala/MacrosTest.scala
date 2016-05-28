package main

import scalaprops._, Property.forAll

object MacrosTest extends Scalaprops {

  val test = Property.prop {
    val hoge = "hoge"
    // Test.test(hoge + "fuga")
    // Test.test("hoge")
    // Test.test {
      // val a = "hoge"
      // val b = "fuga"
      // a + b
    // }

    Test.test {
      val i = 3.toString
      i + "hoge"
    }
    true
  }
}
