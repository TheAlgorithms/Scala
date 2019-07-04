package Mathematics

import org.scalatest.FlatSpec

class BinaryExponentiationSpec extends FlatSpec {

  it should "output the correct Integer as a result for base raised to the power " in {
    assert(BinaryExponentiation.binaryExponentiation(2, 3) === 8)
  }

}
