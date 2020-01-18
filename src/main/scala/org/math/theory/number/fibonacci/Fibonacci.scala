package org.math.theory.number.fibonacci

import java.util.concurrent.TimeUnit

import com.codahale.metrics.ConsoleReporter
import nl.grons.metrics4.scala.DefaultInstrumented

object Fibonacci extends App with DefaultInstrumented {
  val reporter = ConsoleReporter.forRegistry(metricRegistry)
  val rb = reporter.build()
  rb.start(1, TimeUnit.SECONDS)


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

  def optFibonacci(n: Long, a: Long, b: Long): Long = fibonacciTimer2.time {
    if (n == 0) a
    else optFibonacci(n - 1, b, a + b)
  }

  /* assert(fibonacci(2) == 1)
   assert(fibonacci(3) == 2)
   assert((fibonacci(7) == 13)) */
  var retsult = 0L
  //fibonacciTimer.time {

  // }
  val tetsValue = 53
 // retsult = fibonacci(tetsValue)
  retsult = optFibonacci(tetsValue, 0, 1)
  println(s"fibonacci($tetsValue) = $retsult")
  println(s"optFibonacci($tetsValue) = $retsult")

  rb.report()

}
