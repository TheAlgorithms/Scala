package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class PrimeFactorsSpec extends AnyFlatSpec {

  "PrimeFactorsSpec 1" should "output the correct list of all the prime factors of a number" in {
    assert(PrimeFactors.primeFactors(80) === List(2, 2, 2, 2, 5))
  }

}
