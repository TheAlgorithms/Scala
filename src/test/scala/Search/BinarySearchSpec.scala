package Search

import org.scalatest.flatspec.AnyFlatSpec

class BinarySearchSpec extends AnyFlatSpec {
  "A Binary Search" should "return the index of an element in an array" in {
    val l = List.range(1, 10)
    assert(BinarySearch.binarySearch(l, 2) === 1)
    assert(BinarySearch.binarySearch(l, 5) === 4)
  }

  "A Binary Search 1" should "return -1 if the element is not present in the list" in {
    val l = List.range(1, 5)
    val m = List(1, 3, 5, 7)
    assert(BinarySearch.binarySearch(l, 7) === -1)
    assert(BinarySearch.binarySearch(l, 0) === -1)
    assert(BinarySearch.binarySearch(m, 2) === -1)
    assert(BinarySearch.binarySearch(m, 6) === -1)
    assert(BinarySearch.binarySearch(m, 0) === -1)
  }

  "A Binary Search With Range" should "return the index of an element in an array" in {
    val l = List.range(1, 10)
    assert(BinarySearch.binarySearch(l, 2, 0, 5) === 1)
    assert(BinarySearch.binarySearch(l, 5, 3, 6) === 4)
    assert(BinarySearch.binarySearch(l, 2, 6, 9) === -1)
    assert(BinarySearch.binarySearch(l, 5, 1, 3) === -1)
  }

  it should "return -1 if the element is not present in the list" in {
    val l = List.range(1, 5)
    assert(BinarySearch.binarySearch(l, 7, 0, 4) === -1)
    assert(BinarySearch.binarySearch(l, 7, 1, 3) === -1)
  }

  "A lower Bound" should "return the index of first appearance element" in {
    val m = List(1, 3, 5, 5, 5, 9, 9, 13, 13, 20)
    assert(BinarySearch.lowerBound(m, 5) === 2)
    assert(BinarySearch.lowerBound(m, 9) === 5)
  }
  "A lower bound" should "return the index of number larger than an element and which is smallest" in {
    val m = List(1, 3, 5, 5, 5, 9, 9, 13, 13, 20)
    assert(BinarySearch.lowerBound(m, 4) === 2)
    assert(BinarySearch.lowerBound(m, 8) === 5)
    assert(BinarySearch.lowerBound(m, 10) === 7)
  }
}
