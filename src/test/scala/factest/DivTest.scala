package factest

import org.math.theory.number.Divisibility
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class DivTest extends AnyFreeSpec with Matchers {

  "GCD" - {
    "compare results" in {
      Divisibility.gcdEuclidean(252, 198) shouldBe 18
      Divisibility.gcdEuclidean(0, 44) shouldBe 44
      Divisibility.gcdEuclidean(7, 5) shouldBe 1

    }
    "associativity" in {
      Divisibility.gcdEuclidean(252, 198) shouldBe Divisibility.gcdEuclidean(198, 252)
    }
    "three integers" in {
      Divisibility.gcdEuclidean(140, 350) shouldBe 70
      Divisibility.gcdEuclidean(105, 140, 350) shouldBe 35
      // Mutually relatively prime
      Divisibility.gcdEuclidean(15,21,35) shouldBe 1
    }
  }
}
