package Mathematics

object StreamSieve {

  private val allPrimes: Stream[Int] = 2 #:: Stream.from(3).filter { c =>
    val primesUptoSqrt = allPrimes.takeWhile(p => p <= math.sqrt(c))
    !primesUptoSqrt.exists(p => c % p == 0)
  }

  /**
    * Method to use the allPrimes stream to take the first n prime numbers
    * Using streams is both an easy and efficient way to generate fibonacci numbers (streams are memoized)
    * Using streams as opposed to the classic sieve ensures that we stay following functional principles
    * and not change states
    * @param total
    * @return
    */
  def getPrimeNumbers(n: Int): Seq[Int] = allPrimes.take(n)
}
