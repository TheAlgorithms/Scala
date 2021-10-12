package DynamicProgramming

/** An implementation of famous dynamic programming Coin Change Problem Problem Statement: Given an amount and a
  * list of coin change, find number of possible combinations to get the amount
  */

object CoinChange {

  /** @param coins
    *   - a list of integers i.e. change coins
    * @param money
    *   - the target amount
    * @return
    *   - number of combinations possible to get the amount
    */

  def coinChange(coins: List[Int], money: Int): Int = {
    val combinations: Array[Int] = new Array[Int](money + 1)

    combinations(0) = 1

    for (coin <- coins) {
      for (i <- coin to money) {
        if (i >= coin) {
          combinations(i) += combinations(i - coin)
        }
      }
    }

    combinations(money)
  }
}
