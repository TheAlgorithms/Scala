package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class AbsMinSpec extends AnyFlatSpec {

  "abs min spec 1" should "output the correct Integer as a result from the list of elements" in {
    assert(AbsMin.absMin(List(1000, -1, 999, 72, 65, -56, -767)) === 1)
  }

  "abs min spec 2" should "output the correct Integer as a result from the list of elements" in {
    assert(AbsMin.absMin(List(121, 221, 3, 4112)) === 3)
  }

}
