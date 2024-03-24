package Sort

import org.scalatest.flatspec.AnyFlatSpec

class FunctionalMergeSortSpec extends AnyFlatSpec {

  "A Merge Sort" should "return a sorted version of a vector passed to it" in {
    val vec = Vector(3, 2, 7, 1, 9, 0)
    assert(FunctionalMergeSort.mergeSort(vec) === Vector(0, 1, 2, 3, 7, 9))
  }

}
