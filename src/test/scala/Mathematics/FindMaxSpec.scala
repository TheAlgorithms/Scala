package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class FindMaxSpec extends AnyFlatSpec {

  "FindMaxSpec 1" should "output the correct Integer as a result from the list of elements" in {
    assert(FindMax.findMax(List(-1000, -1, 999, 72, 65, -56, -767)) === 999)
  }

  "FindMaxSpec 2" should "output the correct Integer as a result from the list of elements" in {
    assert(FindMax.findMax(List(121, 221, 3, 4112)) === 4112)
  }

}
