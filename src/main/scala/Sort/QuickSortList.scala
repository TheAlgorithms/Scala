package Sort

import scala.annotation.tailrec

/** An implementation of quicksort algorithm to sort of an unsorted integer list
  */
object QuickSortList {
  /** @param list
    *   - a List of unsorted integers
    * @return
    *   - a list of sorted integers
    */
  def quickSortList(list: List[Int]): List[Int] = list match {
    case Nil => list
    case pivot :: other =>
      sort(pivot, other, Nil, Nil) match {
        case (left, right) => quickSortList(left) ::: pivot :: quickSortList(right)
      }
  }

  /** @param piv
    *   - a pivot element
    * @param rem
    *   - remaining elements of the list
    * @param left
    *   - a list of integers less than piv
    * @param right
    *   - a list of integers great than piv
    * @return
    *   (l, r)
    */
  @tailrec
  private def sort(piv: Int, rem: List[Int], left: List[Int], right: List[Int]): (List[Int], List[Int]) = {
    rem match {
      case head :: tail =>
        if (piv > head) sort(piv, tail, head :: left, right)
        else sort(piv, tail, left, head :: right)
      case Nil => (left, right)
    }
  }
}
