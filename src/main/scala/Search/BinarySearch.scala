package Search

/**
  * An implementation of binary search algorithm to search an element in a sorted list
  */

import scala.annotation.tailrec

object BinarySearch {

  /**
    *
    * @param arr   - a sequence of integers
    * @param elem - a integer to search for in the @args
    * @return - index of the @elem or -1 if elem is not fount in the @arr
    */

  def binarySearch(arr: List[Int], elem: Int): Int = {

    @tailrec
    def SearchImpl(lo: Int, hi: Int): Int = {
      if (lo > hi)
        -1
      else {
        val mid: Int = lo + (hi - lo) / 2
        arr(mid) match {
          case mv if (mv == elem) => mid
          case mv if (mv <= elem) => SearchImpl(mid + 1, hi)
          case _ => SearchImpl(lo, mid - 1)
        }
      }
    }

    SearchImpl(0, arr.size - 1)

  }

}