package Mathematics

object AbsMin {

  /** Method returns Absolute minimum Element from the list
    *
    * @param listOfElements
    * @return
    */
  def abs: Int => Int = Abs.abs

  def absMin(elements: List[Int]): Int = abs(elements.minBy(x => abs(x)))

}
