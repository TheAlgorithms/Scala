package Mathematics

object StreamSieve {

  private val allPrimes: Stream[Long] = 2L #:: Stream.from(3).filter { c =>
    val primesUpToSqrt = allPrimes.takeWhile(p => p <= math.sqrt(c))
    !primesUpToSqrt.exists(p => c % p == 0)
  }

  /**
    * Method to use the allPrimes stream to take the first n prime numbers
    * Using streams is both an easy and efficient way to generate fibonacci numbers (streams are memoized)
    * Using streams as opposed to the classic sieve ensures that we stay following functional principles
    * and not change states
    *
    * @param n number of primes to generate
    * @return List of the first n primes
    */
  def getPrimeNumbers(n: Int): Seq[Long] = allPrimes.take(n)
}
