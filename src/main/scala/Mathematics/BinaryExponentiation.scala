package Mathematics

object BinaryExponentiation {

  /** Method returns the binary exponentiation of a given number when base and power are passed the parameters
    *
    * @param Int
    *   , Int
    * @return
    */

  def binaryExponentiation(base: Int, power: Int): Int = {
    if (power == 0) {
      return 1
    } else if (power % 2 == 1) {
      return binaryExponentiation(base, power - 1) * base
    } else {
      val answer: Int = binaryExponentiation(base, power / 2)
      return answer * answer
    }
  }
}
