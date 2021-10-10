package Sort

import org.scalatest.flatspec.AnyFlatSpec

class HeapSortSpec extends AnyFlatSpec {

  "Heap Sort" should "return a sorted version of an array passed to it" in {
    val arr = Array(3, 2, 7, 1, 9, 0)
    assert(HeapSort.heapSort(arr) === Array(0, 1, 2, 3, 7, 9))
  }

  "Heap Sort" should "return empty array when empty array is passed to it" in {
    val arr = Array[Int]()
    assert(HeapSort.heapSort(arr) === Array())
  }
  "Heap Sort" should "not modify array" in {
    val arr = Array(3, 2, 7, 1, 9, 0)
    HeapSort.heapSort(arr)
    assert(arr === Array(3, 2, 7, 1, 9, 0))
  }
}
