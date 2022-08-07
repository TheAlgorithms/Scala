package Mathematics

import org.scalatest.flatspec.AnyFlatSpec

class FindFactorial extends AnyFlatSpec {
  "FindFactorialSpec 1" should "output the correct answer of factorial 5 which is 120" in {
    assert(Factorial.factorialIterative(5) === 120)
    
  "FindFactorialSpec 1" should "output the correct answer of factorial 5 which is 120" in {
    assert(Factorial.factorialRecursive(5) === 120)
  }
}
