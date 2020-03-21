package Mathematics

import org.scalatest.FlatSpec

class AbsSpec extends FlatSpec {

  it should "output the correct Integer as a result of |-1|" in {
    assert(Abs.abs(-1) === 1)
  }

  it should "output the correct Integer as a result of |190|" in {
    assert(Abs.abs(190) === 190)
  }

}
