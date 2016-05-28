package tree

import org.scalatest.{Matchers, FunSpec}

import scala.math.Ordering.IntOrdering

class BTreeSpec extends FunSpec with Matchers  {

  ignore("ignore") {
    describe("BTree#size") {
      it("should return the number of elements in the BTree") {
        BTree(Branch(Leaf(1), 2, Leaf(3))).size shouldBe 3
        BTree(Leaf(1)).size shouldBe 1
      }
    }

    describe("BTree#max") {
      it("should return the max value in the BTree") {
        BTree(Branch(Leaf(1), 2, Leaf(3))).max shouldBe 3
      }
    }

    describe("BTree#min") {
      it("should return the min value in the BTree") {
        BTree(Branch(Leaf(1), 2, Leaf(3))).min shouldBe 1
      }
    }

    describe("BTree#sum") {
      it("should return the sum of values in the BTree") {
        BTree(Branch(Leaf(1), 2, Leaf(3))).sum shouldBe 6
      }
    }

    describe("BTree#avg") {
      it("should return the average of values in the BTree") {
        BTree(Branch(Leaf(1), 2, Leaf(3))).avg shouldBe 2.0d
      }
    }
    
    describe("BTree#find") {
      it("should return a node has the value in the BTree") {
        BTree(Branch(Leaf(1), 2, Leaf(3))).find(1) shouldBe Some(Leaf(1))
      }
    }
  }

  describe("BTree#apply") {
    it("should return a new BTree from List[Int]") {
      BTree(List(1, 2, 3)) shouldEqual BTree(Branch(Leaf(1), 2, Leaf(3)))
      intercept[IllegalArgumentException](BTree(List(1, 2, 3, 4)))
      println(BTree(List(1, 2, 3, 4, 5, 6, 7)))

      BTree(1.to(math.pow(2, 12).toInt - 1).toList)
    }
  }
}
