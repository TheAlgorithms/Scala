package Mathematics

object LinearSieve {
  /**
    * Method returns sequence of prime numbers which all are not greater than n
    *
    * @param n the number of prime numbers to generate
    * @return the first n prime numbers
    */
  def getPrimeNumbers(n: Int): Seq[Long] = {
    var primeNumbers = Seq.empty[Long]
    val lowestPrimeDivisor: Array[Long] = Array.fill(n + 1)(0L)
    for (i <- 2 to n) {
      if (lowestPrimeDivisor(i) == 0) {
        lowestPrimeDivisor(i) = i.toLong
        primeNumbers :+= i.toLong
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
