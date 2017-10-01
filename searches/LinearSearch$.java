/**
 * This is scala implementation of linear search algorithm
 * Run following command:
 * scala LinearSearch.scala
 */
object LinearSearch {
  /**
   *
   * @param args - a sequence of integers
   * @param target - a integer to search for in the @args
   * @return - index of the @target or -1 if target is not fount in the @args
   */
  def Search(args : Seq[Int], target: Int): Int = {
    //the functional way, common in scala would be:
    //args.indexOf(target)
    for(i <- args.indices) {
      if(args(i) == target)
        return i
    }
    -1
  }

  def main(args : Array[String]) {
    println("Enter numbers separated by coma:")
    val input = scala.io.StdIn.readLine()
    try {
      val sequence = input.split(",").map(_.toInt)
      println("Enter a single number to be found in the list:" + input)
      val target = scala.io.StdIn.readLine().toInt
      val foundIndex = Search(sequence, target)
      if(foundIndex > -1){
        println(s"$target found at position $foundIndex")
      } else {
        println("Not found")
      }
    } catch {
      case e: Throwable => println("Seems like some of the inputs are not integers.")
    }
  }
}
