package Others

import org.scalatest.FlatSpec

class FibbonacciSpec extends FlatSpec {

  "recursive solution" should "start from 1" in {
    assert(Fibbonacci.nthNumberRecursive(0) === 1)
  }

  it should "calculate some fibbonacci number" in {
    assert(Fibbonacci.nthNumberRecursive(4) === 5)
  }

  it should "return sum of two previous numbers" in {
    for (i <- 2 to 10) assert(Fibbonacci.nthNumberRecursive(i) === Fibbonacci.nthNumberRecursive(i - 1) + Fibbonacci.nthNumberRecursive(i - 2))
  }

  "iterative solution" should "start from 1" in {
    assert(Fibbonacci.nthNumberIterative(0) === 1)
  }

  it should "calculate some fibbonacci number" in {
    assert(Fibbonacci.nthNumberIterative(4) === 5)
  }

  it should "return sum of two previous numbers" in {
    for (i <- 2 to 20) assert(Fibbonacci.nthNumberIterative(i) === Fibbonacci.nthNumberIterative(i - 1) + Fibbonacci.nthNumberIterative(i - 2))
  }

  "tail recursive solution" should "start from 1" in {
    assert(Fibbonacci.nthNumberTailRec(0) === 1)
  }

  it should "calculate some fibbonacci number" in {
    assert(Fibbonacci.nthNumberTailRec(4) === 5)
  }

  it should "return sum of two previous numbers" in {
    for (i <- 2 to 20) assert(Fibbonacci.nthNumberTailRec(i) === Fibbonacci.nthNumberTailRec(i - 1) + Fibbonacci.nthNumberTailRec(i - 2))
  }
}
