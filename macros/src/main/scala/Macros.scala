package main

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Test {
  def test(str: String): Unit = macro TestMacro.testImpl
}

class TestMacro(val c: blackbox.Context) {
  import c.universe._

  def testImpl(str: c.Expr[String]): c.Expr[Unit] = {
    println(s"prefix = ${c.prefix.tree}")
    println(s"enclosingPos = ${c.enclosingPosition}")
    println(s"pos = ${c.macroApplication.pos}")

    println("-------show")

    val tree = str.tree

    println(show(tree))
    println(showRaw(tree))
    println(showCode(tree))

    println("-------")

    val a = c.freshName(TermName("a"))
    val b = c.freshName(TermName("b"))

    val pf = q"""
      val $a = "hoge"
      val $b = $str + " fuga"

      println($a + " " + $b)
    """

    show(pf)

    c.Expr[Unit](pf)
  }
}
