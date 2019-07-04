package Mathematics

import org.scalatest.FlatSpec

class FindMinSpec extends FlatSpec {

  it should "output the correct Integer as a result from the list of elements" in {
    assert(FindMin.findMin(-1000, -1, 999, 72, 65, -56, -767) === -1000)
  }

  it should "output the correct Integer as a result from the list of elements" in {
    assert(FindMin.findMin(121, 221, 3, 4112) === 3)
  }

}
