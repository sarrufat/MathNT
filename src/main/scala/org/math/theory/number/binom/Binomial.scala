package org.math.theory.number.binom

import scala.annotation.tailrec

object Binomial {

  def factorial(n: Long): BigInt = {
    @tailrec
    def internalRecursive(n1: Long, acc: BigInt): BigInt = {
      if (n1 <= 1) acc
      else internalRecursive(n1 - 1, acc * n1)

    }

    internalRecursive(n, 1)
  }

  def binomialCoefficient(n: Long, k: Long): BigInt = factorial(n) / (factorial(k) * factorial(n - k))

  def pascalGenerator(deep: Int): Seq[Seq[Int]] = (0 to deep).map(row => (0 to row).map(col => binomialCoefficient(row, col).toInt))

}
