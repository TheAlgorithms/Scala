package Search

import org.scalatest.FlatSpec

class InterpolationSearchSpec extends FlatSpec {
  "An Interpolation Search" should "return the index of an element in an array" in{
    val l = List.range(1,10)
    assert(InterpolationSearch.interpolationSearch(l,2)===1)
    assert(InterpolationSearch.interpolationSearch(l,9)===8)
  }

  it should "return -1 if the element is not found in the list" in{
    val l = List(10, 12, 13, 16, 18, 19, 20, 21,
      22, 23, 24, 33, 35, 42, 47)
    assert(InterpolationSearch.interpolationSearch(l,48) === -1)
  }
}
