package DynamicProgramming

import org.scalatest.FlatSpec

class CoinChangeSpec extends FlatSpec  {
  "Coin Change" should "return the number of combinations for the amount1" in {

    assert(CoinChange.coinChange(List(1,2), 4) === 3)
  }

  "Coin Change" should "return the number of combinations for the amount2" in {

    assert(CoinChange.coinChange(List(5,10,20,50,100,200,500), 300) === 1022)
  }

  "Coin Change" should "return the number of combinations for the amount3" in {

    assert(CoinChange.coinChange(List(5,10,20,50,100,200,500), 301) === 0)
  }

  "Coin Change" should "return the number of combinations for the amount4" in {

    assert(CoinChange.coinChange(List(500,5,50,100,20,200,10), 300) === 1022)
  }
}
