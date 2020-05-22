package Search

/**
  * An implementation of binary search algorithm to search an element in a sorted list
  */

import scala.annotation.tailrec

object BinarySearch {

  /**
    * @param arr   - a sequence of integers
    * @param elem - a integer to search for in the @args
    * @return - index of the @elem otherwise -1
    */

  def binarySearch(arr: List[Int], elem: Int): Int = {
    binarySearch(arr, elem, 0, arr.length)
  }

  /**
    * @param arr   - a sequence of integers
    * @param elem - a integer to search for in the @args
    * @param fromIndex - the index of the first element (inclusive) to be searched
    * @param toIndex - toIndex the index of the last element (exclusive) to be searched
    * @param returnInsertIdx - if `true`, returns info about the insertion index
    * @return - index of the @elem otherwise -1. If `returnInsertIdx` is true, returns
    *         (-insertion_idx - 1) where insertion_idx is the 1st index where `elem` can be
    *         inserted into `arr` and `arr` is still sorted.
    */

  def binarySearch(
    arr: List[Int],
    elem: Int,
    fromIndex: Int,
    toIndex: Int,
    returnInsertIdx: Boolean = false
  ): Int = {

    @tailrec
    def SearchImpl(lo: Int, hi: Int): Int = {
      if (lo > hi) {
        if(returnInsertIdx) -lo - 1 else -1
      }
      else {
        val mid: Int = lo + (hi - lo) / 2
        arr(mid) match {
          case mv if (mv == elem) => mid
          case mv if (mv <= elem) => SearchImpl(mid + 1, hi)
          case _ => SearchImpl(lo, mid - 1)
        }
      }
    }

    SearchImpl(fromIndex, toIndex-1)
  }
}