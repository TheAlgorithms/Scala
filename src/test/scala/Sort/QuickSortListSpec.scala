package Sort

import org.scalatest.flatspec.AnyFlatSpec

class QuickSortListSpec extends AnyFlatSpec {
  "A Quick Sort List" should "return a sorted version of a list passed to it" in {
    val list = List(3, 2, 7, 1, 9, 0)
    assert(QuickSortList.quickSortList(list) === List(0, 1, 2, 3, 7, 9))
  }

  "A Quick Sort List" should "return empty list when empty list is passed to it" in {
    val list = List.empty[Int]
    assert(QuickSortList.quickSortList(list) === Nil)
  }

  "A Quick Sort List" should "not modify list" in {
    val list = List(0, 1, 2, 3, 7, 9)
    assert(QuickSortList.quickSortList(list) === List(0, 1, 2, 3, 7, 9))
  }
}
