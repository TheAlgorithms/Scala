package Mathematics

import org.scalatest.FlatSpec

class FibonacciSpec extends FlatSpec {

  it should "output the correct sequence of the first 100 fib numbers" in {
    Fibonacci.fibGenerate(100) === Seq()
  }

  it should "output the correct sequence of the 1000th fib number" in {
    Fibonacci.fibGenerate(1000) === 7927
  }
}
