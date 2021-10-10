package DynamicProgramming

import org.scalatest.flatspec.AnyFlatSpec

class CoinChangeSpec extends AnyFlatSpec {
  "Coin Change 1" should "return the number of combinations for the amount1" in {

    assert(CoinChange.coinChange(List(1, 2), 4) === 3)
  }

  "Coin Change 2" should "return the number of combinations for the amount2" in {

    assert(CoinChange.coinChange(List(5, 10, 20, 50, 100, 200, 500), 300) === 1022)
  }

  "Coin Change 3" should "return the number of combinations for the amount3" in {

    assert(CoinChange.coinChange(List(5, 10, 20, 50, 100, 200, 500), 301) === 0)
  }

  "Coin Change 4" should "return the number of combinations for the amount4" in {

    assert(CoinChange.coinChange(List(500, 5, 50, 100, 20, 200, 10), 300) === 1022)
  }
}
