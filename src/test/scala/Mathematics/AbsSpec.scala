package Mathematics

import org.scalatest.FlatSpec

class AbsSpec extends FlatSpec {

  "abs spec 1" should "output the correct Integer as a result" in {
    assert(Abs.abs(-1) === 1)
  }

  "abs spec 2" should "output the correct Integer as a result" in {
    assert(Abs.abs(190) === 190)
  }

}
