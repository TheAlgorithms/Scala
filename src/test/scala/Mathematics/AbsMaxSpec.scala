package Mathematics

import org.scalatest.FlatSpec

class AbsMaxSpec extends FlatSpec {

  it should "output the correct Integer as a result from the list of elements" in {
    assert(AbsMax.absMax(-1000, -1, 999, 72, 65, -56, -767) === 1000)
  }

  it should "output the correct Integer as a result from the list of elements" in {
    assert(AbsMax.absMax(121, 221, 3, 4112) === 4112)
  }

}
