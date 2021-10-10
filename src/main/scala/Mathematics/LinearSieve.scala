package Mathematics

object LinearSieve {

  /** Method returns sequence of prime numbers which all are not greater than n
    *
    * @param n
    * @return
    */
  def getPrimeNumbers(n: Int): Seq[Int] = {
    var primeNumbers                   = Seq.empty[Int]
    val lowestPrimeDivisor: Array[Int] = Array.fill(n + 1)(0)
    for (i <- 2 to n) {
      if (lowestPrimeDivisor(i) == 0) {
        lowestPrimeDivisor(i) = i
        primeNumbers :+= i
      }
      var j = 0
      while (j < primeNumbers.length && primeNumbers(j) <= lowestPrimeDivisor(i) && i * primeNumbers(j) <= n) {
        lowestPrimeDivisor(i * primeNumbers(j)) = primeNumbers(j)
        j = j + 1
      }
    }
    primeNumbers
  }
}
