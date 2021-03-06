package org.math.theory.number

object Divisibility {
  private def gcdEuclidean(a: BigInt, b: BigInt): BigInt = {
    @scala.annotation.tailrec
    def div(a: BigInt, b: BigInt): BigInt = {
      if (b == 0) a
      else {
        val r = a % b
        if (r == 0) b
        else
          div(b, r)
      }
    }

    if (b < a) div(a, b) else div(b, a)
  }

  def gcdEuclidean(args: BigInt*): BigInt = {
    assert(args.length >= 2)
    if (args.length == 2)
      gcdEuclidean(args.head, args.tail.head)
    else {
      val (a, b) = (args.drop(args.length - 2).head, args.drop(args.length - 1).head)
      val z = gcdEuclidean(a, b)
      args.dropRight(2).foldRight(z) { (a, b) => gcdEuclidean(a, b) }
    }
  }

  def factorize(n: BigInt): Seq[BigInt] = {
    def fact_(n: BigInt, acc: BigInt): Seq[BigInt] =
      if (acc * acc > n) Seq(n)
      else
        (n % acc).toInt match {
          case 0 => acc +: fact_(n / acc, acc)
          case _ => fact_(n, acc + 1)
        }

    fact_(n, 2)
  }
}
