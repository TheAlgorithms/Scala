package Mathematics

object FindMin {

  /** Method returns Minimum Element from the list
    *
    * @param listOfElements
    * @return
    */
  def findMin(elements: List[Int]): Int = elements.foldLeft(elements.head) { (acc, i) => if (acc < i) acc else i }
}
