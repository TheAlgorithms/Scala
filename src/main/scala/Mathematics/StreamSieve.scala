package Mathematics

object StreamSieve {

  private val allPrimes: LazyList[Int] = 2 #:: LazyList.from(3).filter { c =>
    val primesUpToSqrt = allPrimes.takeWhile(p => p <= math.sqrt(c.toDouble))
    !primesUpToSqrt.exists(p => c % p == 0)
  }

  /** Method to use the allPrimes stream to take the first n prime numbers Using streams is both an easy and
    * efficient way to generate fibonacci numbers (streams are memoized) Using streams as opposed to the classic
    * sieve ensures that we stay following functional principles and not change states
    */
  def getPrimeNumbers(n: Int): Seq[Int] = allPrimes.take(n)
}
