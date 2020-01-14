package Sort

import org.scalatest.FlatSpec

class QuickSortSpec extends FlatSpec {

  "A Quick Sort" should "return a sorted version of an array passed to it" in {
    val list = List(3,2,7,1,9,0)
    assert(QuickSort.quickSort(list) === List(0,1,2,3,7,9))
  }
  
  "A Quick Sort" should "return empty list when empty list is passed to it" in {
    val list: List[Int] = List()
    assert(QuickSort.quickSort(list) === List())
  }

}
