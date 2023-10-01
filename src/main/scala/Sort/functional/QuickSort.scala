package Sort.functional

object QuickSort {
  def quickSort(arr: List[Int]): List[Int] = {
    // Base case: empty or singleton list is already sorted
    if (arr.length <= 1) {
      return arr
    }

    // Choose the first element as the pivot
    val pivot = arr.head

    // Partition the list into two sublists:
    // elements smaller than or equal to pivot, and elements greater than pivot
    val (smaller, greater) = arr.tail.partition(_ <= pivot)

    // Recursively sort the sublists and concatenate them with the pivot
    quickSort(smaller) ::: pivot :: quickSort(greater)
  }
}