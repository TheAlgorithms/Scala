object BubbleSort {
  def main(args: Array[String]) {
    val array = new Array[Int](6)

    //Input
    println("Enter any 6 Numbers for Unsorted Array : ")
    for (i <- 0 to 5) {
      array(i) = scala.io.StdIn.readLine().toInt
    }

    //Sorting
    for (i <- 0 to 5) {
      for (j <- 0 to 4) {
        if (array(j) > array(j + 1)) {
          var temp = array(j)
          array(j) = array(j + 1)
          array(j + 1) = temp
        }
      }
    }

    //Output
    println(array.mkString("\t"))
  }
}
