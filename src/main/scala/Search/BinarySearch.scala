package Search

/** An implementation of binary search algorithm to search an element in a sorted list
  */

import scala.annotation.tailrec

object BinarySearch {

  /** @param arr
    *   - a sequence of integers
    * @param elem
    *   - a integer to search for in the @args
    * @return
    *   - index of the @elem otherwise -1
    */

  def binarySearch(arr: List[Int], elem: Int): Int = {
    binarySearch(arr, elem, 0, arr.length)
  }

  /** @param arr
    *   - a sequence of integers
    * @param elem
    *   - a integer to search for in the @args
    * @param fromIndex
    *   - the index of the first element (inclusive) to be searched
    * @param toIndex
    *   - toIndex the index of the last element (exclusive) to be searched
    * @return
    *   - index of the @elem otherwise -1
    */

  def binarySearch(arr: List[Int], elem: Int, fromIndex: Int, toIndex: Int): Int = {

    @tailrec
    def SearchImpl(lo: Int, hi: Int): Int = {
      if (lo > hi)
        -1
      else {
        val mid: Int = lo + (hi - lo) / 2
        arr(mid) match {
          case mv if (mv == elem) => mid
          case mv if (mv <= elem) => SearchImpl(mid + 1, hi)
          case _                  => SearchImpl(lo, mid - 1)
        }
      }
    }

    SearchImpl(fromIndex, toIndex - 1)
  }

  /** @param arr
    *   - a sequence of integers
    * @param elem
    *   - a integer to search for in the @args
    * @return
    */
  def lowerBound(arr: List[Int], elem: Int): Int = {
    lowerBound(arr, elem, 0, arr.length - 1)
  }

  /** @param arr
    *   - a sequence of integers
    * @param elem
    *   - a integer to search for in the @args
    * @param lo
    *   - lowest value index
    * @param hi
    *   - highest value index
    * @return
    */
  def lowerBound(arr: List[Int], elem: Int, lo: Int, hi: Int): Int = {
    if (lo == hi) lo
    else {
      val m: Int = lo + (hi - lo) / 2
      arr(m) match {
        case mv if (mv < elem)  => lowerBound(arr, elem, m + 1, hi)
        case mv if (mv >= elem) => lowerBound(arr, elem, lo, m)
      }
    }
  }
}
