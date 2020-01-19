package factest

import org.math.theory.number.fibonacci.Fibonacci
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class FibonacciTest extends AnyFreeSpec with Matchers {

  "Fibonacci" - {
    "binomialFibonacci compare results with optFibonacci" in {
      val N = 2148
      Fibonacci.binomialFibonacci(N) shouldBe Fibonacci.optFibonacci(N)
    }
  }
}
