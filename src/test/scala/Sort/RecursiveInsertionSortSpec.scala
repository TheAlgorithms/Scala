package Sort

import org.scalatest.flatspec.AnyFlatSpec

class RecursiveInsertionSortSpec extends AnyFlatSpec {

  "A Recursive Insertion Sort" should "return a sorted version of a list passed to it" in {
    val arr = List(3, 2, 7, 1, 9, 0)
    assert(RecursiveInsertionSort.recursiveInsertionSort(arr) === List(0, 1, 2, 3, 7, 9))
  }

}
