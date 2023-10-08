package Sort.functional

import org.scalatest.flatspec.AnyFlatSpec

class MergeSortSpec extends AnyFlatSpec {

  "A Functional Merge Sort" should "return a sorted version of a List passed to it" in {
    assert(MergeSort.mergeSort(List(8,3,6,1,5,9,6,2)) === List(1,2,3,5,6,6,8,9))
  }

}
