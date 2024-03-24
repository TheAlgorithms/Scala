package Sort

object FunctionalMergeSort {

  /** @param vector
    *   - a vector of unsorted integers
    * @return
    *   - vector of sorted integers @vector
    */

  @scala.annotation.tailrec
  def merge(lh: Vector[Int], uh: Vector[Int], acc: Vector[Int] = Vector()): Vector[Int] = {
    (lh, uh) match {
      case (lhd +: ltl, uhd +: _) if lhd <= uhd => merge(ltl.toVector, uh, acc.appended(lhd))
      case (lhd +: _, uhd +: utl) if lhd > uhd  => merge(lh, utl.toVector, acc.appended(uhd))
      case (Vector(), uh)                       => acc ++ uh
      case _                                    => acc ++ lh
    }
  }

  def mergeSort(xs: Vector[Int]): Vector[Int] = {
    if (xs.length <= 1) xs
    else {
      val m        = xs.length / 2
      val (lh, uh) = xs.splitAt(m)
      merge(mergeSort(lh), mergeSort(uh))
    }
  }

}
