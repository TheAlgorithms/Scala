package Mathematics

import org.scalatest.FlatSpec

class GreatestCommonDivisorSpec extends FlatSpec {

  "GreaterCommonDivisorSpec 1" should "output the correct Integer as a result Greatest Common Divisor of two numbers" in {
    assert(GreatestCommonDivisor.gcd(80, 10) === 10)
  }

  "GreaterCommonDivisorSpec 2" should "output the correct Integer as a result Greatest Common Divisor of two numbers" in {
    assert(GreatestCommonDivisor.gcd(7, 95) === 1)
  }

}
