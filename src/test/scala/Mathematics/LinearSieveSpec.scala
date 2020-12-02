package Mathematics

import org.scalatest.FlatSpec

class LinearSieveSpec extends FlatSpec {
  "Linear sieve" should "return all prime numbers for specific n" in {
    val n = 15
    assert(LinearSieve.getPrimeNumbers(n) === List(2, 3, 5, 7, 11, 13))
  }

  "Linear sieve 1" should "return only prime numbers for specific n" in {
    val n = 15000
    LinearSieve.getPrimeNumbers(n).foreach(x => assert(isPrime(x)))
  }

  def isPrime(n: Long): Boolean = {
    for (i <- 2 until n) if (n % i == 0) false
    true
  }
}



