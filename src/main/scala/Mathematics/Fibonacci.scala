package Mathematics

object Fibonacci {
  private val allFibonacci: Stream[Long] = 1L #:: 1L #:: allFibonacci.zip(allFibonacci.tail).map(t => t._1 + t._2)

  /**
    * Method to use the allFibonacci stream to take the first total numbers
    * Using streams is both an easy and efficient way to generate fibonacci numbers (streams are memoized)
    *
    * @param total is the number of fibonacci numbers to generate
    * @return the first total fibonacci numbers
    */
  def fibGenerate(total: Int): Seq[Long] = allFibonacci.take(total)
}
