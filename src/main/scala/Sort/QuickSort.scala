package Sort

object QuickSort {

  /** @param array
    *   - a sequence of unsorted integers
    * @return
    *   - sequence of sorted integers @array
    */

  def quickSort(array: Array[Int]): Array[Int] = {

    def quickSortImpl(array: Array[Int], first: Int, last: Int): Array[Int] = {
      var pivot: Int = 0
      var i: Int     = 0
      var j: Int     = 0
      var temp: Int  = 0

      if (first < last) {
        pivot = first
        i = first
        j = last

        while (i < j) {
          while (array(i) <= array(pivot) && i < last) {
            i += 1
          }

          while (array(j) > array(pivot)) {
            j -= 1
          }

          if (i < j) {
            temp = array(i)
            array(i) = array(j)
            array(j) = temp
          }
        }

        temp = array(pivot)
        array(pivot) = array(j)
        array(j) = temp
        quickSortImpl(array, first, j - 1)
        quickSortImpl(array, j + 1, last)
      }

      array
    }

    quickSortImpl(array, 0, array.length - 1)
  }
}
