package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class FibonacciSpec extends AnyFlatSpec {

  "FibonacciSpec 1" should "output the correct sequence of the first 40 fib numbers" in {
    assert(
      Fibonacci.fibGenerate(40) === Seq(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
        4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309,
        3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155)
    )
  }

  it should "output the correct sequence of the 45th fib number" in {
    assert(Fibonacci.fibGenerate(45).last === 1134903170)
  }
}
