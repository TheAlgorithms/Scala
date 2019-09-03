package Array

import org.scalatest.FlatSpec

class MaximumAbsoluteDifferenceSpec extends FlatSpec {

  it should "output the correct Integer as a result" in {
    assert(MaximumAbsoluteDifferenceSpec.maxAbsDiff(Array(1, 3, -1) === 5)
  }

  it should "output the correct Integer as a result" in {
    assert(MaximumAbsoluteDifferenceSpec.maxAbsDiff(Array(4, 3, 0, 9, -1, 6, -5)) === 17)
  }

}
