package Mathematics

object Fibonacci {
  private val allFibonacci: LazyList[Int] = 1 #:: 1 #:: allFibonacci.zip(allFibonacci.tail).map(t => t._1 + t._2)

  /** Method to use the allFibonacci stream to take the first total numbers Using streams is both an easy and
    * efficient way to generate fibonacci numbers (streams are memoized)
    *
    * @param total
    *   Maximum number of elements of the sequence
    * @return
    */
  def fibGenerate(total: Int): Seq[Int] = allFibonacci.take(total)
}
