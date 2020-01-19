package org.math.theory.number.fibonacci

import java.util.concurrent.TimeUnit

import com.codahale.metrics.ConsoleReporter
import nl.grons.metrics4.scala.DefaultInstrumented
import org.math.theory.number.binom.Binomial

import scala.annotation.tailrec

object Fibonacci extends App with DefaultInstrumented {
  val reporter = ConsoleReporter.forRegistry(metricRegistry)
  val rb = reporter.build()
  rb.start(10, TimeUnit.SECONDS)

  // Define a timer metric
  private[this] val fibonacciTimer = metrics.timer("fibonacci")
  private[this] val fibonacciTimer2 = metrics.timer("fiboOpt")

  // Not optimized fibonacci: takes a lot of time
  def fibonacci(n: Long): Long = fibonacciTimer.time {
    if (n > 1)
      fibonacci(n - 1) + fibonacci(n - 2)
    else
      n
  }
@tailrec
  def optFibonacci(n: Long, a: BigInt = 0, b: BigInt = 1): BigInt =
    if (n == 0L) a
    else optFibonacci(n - 1, b, a + b)

  def binomialFibonacci(n1: Long): BigInt = {
    if (n1 <= 2L) 1
    else {
      val n = n1 - 1
      (0L to (n / 2L + 1)).map(i => Binomial.binomialCoefficient(n - i, i)).sum
    }
  }

  /* assert(fibonacci(2) == 1)
   assert(fibonacci(3) == 2)
   assert((fibonacci(7) == 13)) */
  var retsult: BigInt = 0
  //fibonacciTimer.time {

  // }
  val tetsValue = 2148
  // retsult = fibonacci(tetsValue)
  retsult = fibonacciTimer2.time {
    binomialFibonacci(tetsValue)
  }
  println(s"fibonacci($tetsValue) = $retsult")
  retsult = fibonacciTimer.time {
    optFibonacci(tetsValue)
  }
  println(s"optFibonacci($tetsValue) = $retsult")

  rb.report()

}
