package Sort.functional

import org.scalatest.flatspec.AnyFlatSpec

class QuickSortSpec extends AnyFlatSpec {

  "A Functional Quick Sort" should "return a sorted version of a List passed to it" in {
    assert(QuickSort.quickSort(List(6,2,4,1,3)) === List(1,2,3,4,6))
  }

}
