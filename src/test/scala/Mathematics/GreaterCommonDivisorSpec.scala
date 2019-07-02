package Mathematics

import org.scalatest.FlatSpec

class GreaterCommonDivisorSpec extends FlatSpec {

  it should "output the correct Integer as a result Greatest Common Divisor of two numbers" in {
    assert(GreaterCommonDivisor.gcd(80, 10) === 10)
  }

  it should "output the correct Integer as a result Greatest Common Divisor of two numbers" in {
    assert(GreaterCommonDivisor.gcd(7, 95) === 1)
  }

}
