package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class PythagoreanTheoremSpec extends AnyFlatSpec {

  "Pythagorean Theorem 1" should "output the correct distant" in {
    assert(PythagoreanTheorem.distance(3,4) === 5)
  }

}