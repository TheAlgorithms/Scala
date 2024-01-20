package Others

import scala.annotation.tailrec

/**
  * Assuming that sequence starts from 0
  */
object Fibbonacci {
  /**
    * Standard recursion solution,
    *
    * @param n - which Fibbonacci number
    * @return
    */
  def nthNumberRecursive(n: Int): Int = {
    if (n <= 1) 1
    else nthNumberRecursive(n - 1) + nthNumberRecursive(n - 2)
  }

  def nthNumberIterative(n: Int): Int = {
    var first = 1
    var second = 1
    if (n == 0) first
    else if (n == 1) second
    else {
      var third: Int = first + second
      for (i <- 3 to n) {
        first = second
        second = third
        third = first + second
      }
      third
    }
  }

  def nthNumberTailRec(n: Int): Int = {
    @tailrec
    def nthNumber(n: Int, current: Int, temp: Int): Int = n match {
      case 0 => current
      case _ => nthNumber(n - 1, temp, current + temp)
    }

    nthNumber(n, 1, 1)
  }

}
