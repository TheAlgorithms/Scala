package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class BinaryExponentiationSpec extends AnyFlatSpec {

  it should "output the correct Integer as a result for base raised to the power " in {
    assert(BinaryExponentiation.binaryExponentiation(2, 3) === 8)
  }

}
