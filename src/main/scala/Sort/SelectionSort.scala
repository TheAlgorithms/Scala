package Sort

object SelectionSort {

  /**
    *
    * @param array - a sequence of unsorted integers
    * @return - sequence of sorted integers @array
    */
  def selectionSort(array: Array[Int]): Array[Int] = {

    for(i <- array.indices) {

      var min: Int = i
      var minVal = array(i)

      for(j <- i + 1 until array.length) {
        if(array(j) < minVal) {
          min = j
          minVal = array(j)
        }
      }

      val temp: Int = array(i)
      array(i)=array(min)
      array(min)=temp

    }

    array
  }
}