package Sort

import org.scalatest.flatspec.AnyFlatSpec

class SelectionSortSpec extends AnyFlatSpec {

  "A Selection Sort" should "return a sorted version of an array passed to it" in {
    val arr = Array(3, 2, 7, 1, 9, 0)
    assert(SelectionSort.selectionSort(arr) === Array(0, 1, 2, 3, 7, 9))
  }

}
