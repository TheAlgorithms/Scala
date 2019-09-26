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
    val m = List(1,3,5,7)
    assert(BinarySearch.binarySearch(l,7) === -1)
    assert(BinarySearch.binarySearch(l,0) === -1)
    assert(BinarySearch.binarySearch(m,2) === -1)
    assert(BinarySearch.binarySearch(m,6) === -1)
    assert(BinarySearch.binarySearch(m,0) === -1)
  }

  "A Binary Search With Range" should "return the index of an element in an array" in {
    val l = List.range(1,10)
    assert(BinarySearch.binarySearch(l,2,0,5) === 1)
    assert(BinarySearch.binarySearch(l,5,3,6) === 4)
    assert(BinarySearch.binarySearch(l,2,6,9) === -1)
    assert(BinarySearch.binarySearch(l,5,1,3) === -1)
  }

  it should "return -1 if the element is not present in the list" in {
    val l = List.range(1,5)
    assert(BinarySearch.binarySearch(l,7,0,4) === -1)
    assert(BinarySearch.binarySearch(l,7,1,3) === -1)
  }

  it should "return insertion index if the element is not found" in {
    def search(l: List[Int], elem: Int) = {
      val rs = BinarySearch.binarySearch(l, elem, 0, l.length, returnInsertIdx = true)
      -rs - 1
    }

    val l = List(-5, 10, 15)
    assert(search(l, 0) === 1)
    assert(search(l, 1) === 1)
    assert(search(l, 12) === 2)
    assert(search(l, 22) === 3)
  }
}
