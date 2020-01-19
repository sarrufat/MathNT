package factest

import org.math.theory.number.binom.Binomial
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class BinomialTest extends AnyFreeSpec with Matchers {

  "Factorial" - {
    "1" in {
      Binomial.factorial(1) shouldBe 1
    }
    "3" in {
      Binomial.factorial(3) shouldBe 6
    }

    "20" in {
      Binomial.factorial(20) shouldBe 2432902008176640000L
    }
    "31" in {
      Binomial.factorial(31).toString() shouldBe "8222838654177922817725562880000000"
    }

    "check stack overflow" in {
      noException should be thrownBy Binomial.factorial(10240)
    }

  }

  "binomialCoefficient" - {
    "5 3" in {
      Binomial.binomialCoefficient(5, 3) shouldBe 10
    }

    "100 90" in {
      Binomial.binomialCoefficient(100, 90) shouldBe 17310309456440L
    }
  }

  "Pascal " - {
    "Deep 4" in {
      val p4 = Binomial.pascalGenerator(4)
      p4(0) shouldBe Seq(1)
      p4(1) shouldBe Seq(1, 1)
      p4(2) shouldBe Seq(1, 2, 1)
      p4(3) shouldBe Seq(1, 3, 3, 1)
    }
    "Deep 10" in {
      val p4 = Binomial.pascalGenerator(10)
      p4(4) shouldBe Seq(1, 4, 6, 4, 1)
      p4(5) shouldBe Seq(1, 5, 10, 10, 5, 1)
      p4(6) shouldBe Seq(1, 6, 15, 20, 15, 6, 1)
      p4(7) shouldBe Seq(1, 7, 21, 35, 35, 21, 7, 1)
      p4(8) shouldBe Seq(1, 8, 28, 56, 70, 56, 28, 8, 1)
      p4(9) shouldBe Seq(1, 9, 36, 84, 126, 126, 84, 36, 9, 1)
    }
  }
}
