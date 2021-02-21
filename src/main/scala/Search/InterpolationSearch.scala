package Search

/*
  An implementation of the Interpolation algorithm to search an
  element in a sorted list of uniformly distributed values.
  Interpolation algorithm is based on the binary search algorithm but instead of going to
  the middle element, it checks elements closer to the edges.
 */
object InterpolationSearch {
  /**
   *
   * @param arr  a sequence of uniformly distributed values
   * @param elem an integer to search for in @arr
   * @return index of the @elem else -1
   */
  def interpolationSearch(arr: List[Int], elem: Int): Int = {
    var low = 0
    var high = arr.size - 1

    while (low <= high && elem>=arr(low) && elem <=arr(high)) {
      //The interpolation formula that decides the next position keeping the uniform distribution in mind.
      var pos = low + ((elem - arr(low)) * (high - low) / (arr(high) - arr(low)))
      //Target index found
      if (arr(pos) == elem) {
        return pos
      }
      //If target is bigger, search right part of list.
      else if (arr(pos) < elem) {
        low = pos + 1
      }
      //If target is lower, search left part of list.
      else {
        high = pos - 1
      }
    }
    //If element is not found.
    -1
  }
  def main(args:Array[String]):Unit ={
    val arr = List(10, 12, 13, 16, 18, 19, 20, 21,
      22, 23, 24, 33, 35, 42, 47)

    println(interpolationSearch(arr,48))
  }
}
