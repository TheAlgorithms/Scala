package Search

import org.scalatest.FlatSpec

class BinarySearchSpec extends FlatSpec {
  "A Binary Search" should "return the index of an element in an array" in {
    val l = List.range(1,10)
    assert(BinarySearch.binarySearch(l,2) === 1)
    assert(BinarySearch.binarySearch(l,5) === 4)
  }

  it should "return -1 if the element is not present in the list" in {
    val l = List.range(1,5)
    assert(BinarySearch.binarySearch(l,7) === -1)
  }
}
