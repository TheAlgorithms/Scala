package Sort.functional

object MergeSort {

  /*
  * The concept behind merge sort is very simple.
  * Keep splitting the array into halves until the subarrays hit a size of one, sort them, and merge the sorted arrays,
  * which will result in an ultimate sorted array. Y
  * ou might have figured out that this sounds exactly like the fibonacci sequence using recursion, and you would be right!
  * We can, and will be using recursion to perform this.
  * Worst case - Big O(nlogn)
  * */

  // A function to merge two sorted lists
  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    // If either list is empty, return the other list
    case (Nil, _) => ys
    case (_, Nil) => xs
    // If the first element of xs is smaller than the first element of ys,
    // append it to the result of merging the rest of xs with ys
    case (x :: xtail, y :: ytail) =>
      if (x < y) x :: merge(xtail, ys)
      // Otherwise, append the first element of ys to the result of merging xs with the rest of ys
      else y :: merge(xs, ytail)
  }

  // A function to sort a list using merge sort
  def mergeSort(xs: List[Int]): List[Int] = {
    // Find the middle index of the list
    val n = xs.length / 2
    // If the list has less than two elements, it is already sorted
    if (n == 0) xs
    else {
      // Split the list into two sublists
      val (left, right) = xs.splitAt(n)
      // Sort each sublist recursively and merge them
      merge(mergeSort(left), mergeSort(right))
    }
  }

}
