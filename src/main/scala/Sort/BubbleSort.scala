package Sort

import util.control.Breaks._

object BubbleSort {

  /**
    *
    * @param array   - a sequence of unsorted integers
    * @return - sequence of sorted integers @array
    */
  def bubbleSort(array: Array[Int]) :  Array[Int] = {

    breakable {
      for (i <- 0 to array.length - 1) {
        var swap = false

        for (j <- 0 to array.length - 2) {
          if (array(j) > array(j + 1)) {
            val temp = array(j)
            array(j) = array(j + 1)
            array(j + 1) = temp
            swap = true
          }
        }

        if (!swap) {
          break
        }
      }
    }

    array
  }

}