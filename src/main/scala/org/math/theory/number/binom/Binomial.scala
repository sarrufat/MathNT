package org.math.theory.number.binom

import scala.annotation.tailrec

object Binomial extends App {

  def factorial(n: Int): BigInt = {
    @tailrec
    def internalRecursive(n1: Int, acc: BigInt) : BigInt = {
      if (n1 <= 1) acc
      else internalRecursive(n1-1, acc*n1)

    }
    internalRecursive(n, 1)
  }
  def binomialCoefficient(n: Int, k: Int): BigInt = factorial(n) /(factorial(k) * factorial(n-k))
}
