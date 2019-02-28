package Search

import scala.math.min
import scala.math.sqrt
import scala.math.floor

object JumpSearch {

  def jumpSearch(arr: List[Int], elem: Int): Int = {

    val len = arr.size
    var a: Int = 0
    var b: Int = floor(sqrt(len)).toInt

    while (arr(min(b, len) - 1) < elem) {
      a = b
      b = b + floor(sqrt(len)).toInt
      if (a >= len){
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
      return a
    }
    else {
      return -1
    }
  }

}
