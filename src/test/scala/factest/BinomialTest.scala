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
}
