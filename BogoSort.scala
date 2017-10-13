import util.Random

object BogoSort {
  def CheckIfSorted(args: Array[Int], size: Int): Boolean = {
    for (i <- 0 until size) {
      if (args(i) > args(i + 1))
        return false
    }
    true
  }

  def shuffle(args: Array[Int], size: Int): Unit = {
    var r: Int = 0
    var t: Int = 0
    for (i <- 0 to size) {
      t = args(i)
      r = Random.nextInt(100) % size
      args(i) = args(r)
      args(r) = t
    }
  }

  def main(args: Array[String]) {
    val array = new Array[Int](6)
    println("Enter 6 unsorted numbers : ")

    // Input
    for (i <- 0 to 5)
      array(i) = scala.io.StdIn.readLine().toInt

    // Sorting
    while (CheckIfSorted(array, 5))
      shuffle(array, 5)

    println("\nSorted Array : " + array.mkString("\t"))
  }
}
