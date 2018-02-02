package Search

/**
  * An implementation of binary search algorithm to search an element in a sorted list
  */

import scala.annotation.tailrec

object BinarySearch {

  /**
    * @param arr   - a sequence of integers
    * @param elem - a integer to search for in the @args
    * @return - index of the @elem otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
    * The <i>insertion point</i> is defined as the point at which the @elem
    * would be inserted into the array: the index of the first
    * element in the range greater than the @elem,or <tt>toIndex</tt> if all
    * elements in the range are less than the specified @elem.
    */

  def binarySearch(arr: List[Int], elem: Int): Int = {
    binarySearch(arr,elem,0,arr.length)
  }


  /**
    * @param arr   - a sequence of integers
    * @param elem - a integer to search for in the @args
    * @param fromIndex - the index of the first element (inclusive) to be searched
    * @param toIndex - toIndex the index of the last element (exclusive) to be searched
    * @return - index of the @elem otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
    * The <i>insertion point</i> is defined as the point at which the @elem
    * would be inserted into the array: the index of the first
    * element in the range greater than the @elem,or <tt>toIndex</tt> if all
    * elements in the range are less than the specified @elem.
    */

  def binarySearch(arr: List[Int], elem: Int, fromIndex: Int, toIndex: Int): Int = {

    @tailrec
    def SearchImpl(lo: Int, hi: Int): Int = {
      if (lo > hi)
        -(lo + 1)
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