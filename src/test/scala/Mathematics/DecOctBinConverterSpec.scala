package Mathematics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should._

class DecOctBinConverterSpec extends AnyFlatSpec with Matchers{


  "The integer number converted to decimal number" should "output the correct result " in {
    assert(DecOctBinConverter.decimalConverter(100) === 100)
  }

  "The integer number converted to octal number" should "output the correct result " in {
    assert(DecOctBinConverter.octalConverter(100) === 144)
  }

  "The integer number converted to binary number" should "output the correct result " in {
    assert(DecOctBinConverter.binaryConverter(100) === 1100100)
  }

}
