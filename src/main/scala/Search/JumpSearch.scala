package Search

import scala.math.{floor, min, sqrt}

object JumpSearch {

  /** An implementation of the jump search algorithm in scala used to search a sorted list
    * @param arr
    *   - a list of integers
    * @param elem
    *   - an integer to search for in @arr
    * @return
    *   - index of the @elem otherwise -1
    */
  def jumpSearch(arr: List[Int], elem: Int): Int = {

    val len    = arr.size
    var a: Int = 0
    var b: Int = floor(sqrt(len.toDouble)).toInt

    while (arr(min(b, len) - 1) < elem) {
      a = b
      b = b + floor(sqrt(len.toDouble)).toInt
      if (a >= len) {
        return -1
      }
    }

    while (arr(a) < elem) {
      a = a + 1
      if (a == min(b, len)) {
        return -1
      }
    }

    if (arr(a) == elem) {
      a
    } else {
      -1
    }
  }

}
