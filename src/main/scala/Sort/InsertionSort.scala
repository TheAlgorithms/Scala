package Sort

object InsertionSort {

  /** @param array
    *   - a sequence of unsorted integers
    * @return
    *   - sequence of sorted integers @array
    */

  def insertionSort(array: Array[Int]): Array[Int] = {

    for (i <- 0 to array.length - 1) {
      val temp: Int = array(i)
      var j         = i - 1
      while (j >= 0 && temp < array(j)) {
        array(j + 1) = array(j)
        j -= 1
      }

      array(j + 1) = temp
    }

    array
  }

}
