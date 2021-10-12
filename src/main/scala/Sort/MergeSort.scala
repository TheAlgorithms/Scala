package Sort

object MergeSort {

  /** @param array
    *   - a sequence of unsorted integers
    * @return
    *   - sequence of sorted integers @array
    */

  def mergeSort(array: Array[Int]): Array[Int] = {

    def sort(array: Array[Int]): Array[Int] = {
      MS(array, 0, array.length - 1)
    }

    def MS(array: Array[Int], low: Int, high: Int): Array[Int] = {
      if (low < high) {
        val mid = (low + high) / 2
        MS(array, low, mid)
        MS(array, mid + 1, high)
        merge(array, low, mid, high)
      } else {
        array
      }
    }

    def merge(array: Array[Int], low: Int, mid: Int, high: Int): Array[Int] = {
      // copy subarrays
      val left  = array.slice(low, mid + 1)
      val right = array.slice(mid + 1, high + 1)

      var i = 0
      var j = 0
      var k = low
      while (k < high + 1) {
        // must check if empty to avoid exceptions
        if (i > left.length - 1) {
          array(k) = right(j)
          j = j + 1
        } else if (j > right.length - 1) {
          array(k) = left(i)
          i = i + 1
        } else if (left(i) <= right(j)) {
          array(k) = left(i)
          i = i + 1
        } else {
          array(k) = right(j)
          j = j + 1
        }
        k = k + 1
      }

      array

    }

    sort(array)
  }

}
