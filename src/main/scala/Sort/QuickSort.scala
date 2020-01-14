package Sort

object QuickSort {
  /**
    *
    * @param list - a list of unsorted integers
    * @return - sequence of sorted integers @list
    */

  def partition(list: List[Int]): (List[Int], List[Int]) = list match {
    case Nil => (Nil, Nil)
    case _ => {
      list.partition {
        val pivot = util.Random.nextInt(list.length)
        _ < list(pivot)  
      }
    }
  }
  
  def quickSort(list: List[Int]): List[Int] = partition(list) match {
    case (Nil, Nil) => Nil
    case (l, Nil) => l
    case (Nil, r) => r
    case (l, r) => {
      quickSort(l) ::: quickSort(r)
    }
  }
}