package Search

import scala.annotation.tailrec

/** This is scala implementation of linear search algorithm
  */
object LinearSearch {

  /** @param arr
    *   - a sequence of integers
    * @param elem
    *   - a integer to search for in the @args
    * @return
    *   - index of the @elem or -1 if elem is not fount in the @arr
    */
  def linearSearch(arr: Vector[Int], elem: Int): Int = {
    @tailrec
    def iter(index: Int): Int =
      if (index == arr.length) -1
      else if (arr(index) == elem) index
      else iter(index + 1)

    iter(0)
  }

}
