package Mathematics

object AbsMax {

  /** Method returns absolute Maximum Element from the list
    *
    * @param listOfElements
    * @return
    */
  def abs: Int => Int = Abs.abs

  def absMax(elements: List[Int]): Int = abs(elements.maxBy(x => abs(x)))

}
