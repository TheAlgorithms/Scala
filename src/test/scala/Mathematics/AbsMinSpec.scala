package Mathematics

import org.scalatest.FlatSpec

class AbsMinSpec extends FlatSpec {

  it should "output the correct Integer as a result from the list of elements" in {
    assert(AbsMin.absMin(List(1000, -1, 999, 72, 65, -56, -767)) === 1)
  }

  it should "output the correct Integer as a result from the list of elements v2" in {
    assert(AbsMin.absMin(List(121, 221, 3, 4112)) === 3)
  }

}
