/**
 * Created by sake92 on 07.10.2017
 */
 
object MergeSort {
  
  def main(args: Array[String]) {
    val NumElems = 6
    val array = new Array[Int](NumElems)

    //Input
    println(s"Enter any $NumElems numbers for unsorted array : ")
    for (i <- 0 until NumElems) {
      array(i) = scala.io.StdIn.readLine().toInt
    }

    //Sorting
    sort(array)

    //Output
    for (e <- array) {
      print(e + "\t")
    }
  }

  def sort(array: Array[Int]): Array[Int] = {
    mergeSort(array, 0, array.length - 1)
  }

  def mergeSort(array: Array[Int], low: Int, high: Int): Array[Int] = {
    if (low < high) {
      val mid = (low + high) / 2
      mergeSort(array, low, mid)
      mergeSort(array, mid + 1, high)
      merge(array, low, mid, high)
    } else {
      array
    }
  }

  def merge(array: Array[Int], low: Int, mid: Int, high: Int): Array[Int] = {
    // copy subarrays
    val left = array.slice(low, mid + 1)
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

}