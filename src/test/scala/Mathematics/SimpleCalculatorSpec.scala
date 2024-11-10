package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class SimpleCalculatorSpec extends AnyFlatSpec{
    
    "Two number with addition" should "output the correct result " in{
        assert(SimpleCalculator.add(5,6) === 11)
    }

    "Two number with substract" should "output the correct result " in{
        assert(SimpleCalculator.substract(6,5) === 1)
    }

    "Two number with multiply" should "output the correct result " in{
        assert(SimpleCalculator.multiply(5,6) === 30)
    }

    "Two number with division" should "output the correct result " in{
        assert(SimpleCalculator.add(12,6) === 2)
    }

}
