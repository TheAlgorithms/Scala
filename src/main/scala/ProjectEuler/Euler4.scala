package ProjectEuler

object Euler4 {
    /** 
	*Problem Statement : A palindromic number reads the same both ways.
	*The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

	*Find the largest palindrome made from the product of two 3-digit numbers.

    **/
	def isPalindrome(num: Int): Boolean = {
	    val numString = num.toString
	    numString == numString.reverse
	}

	def main(args : Array[String]){
	    val palindromes = for (x <- 100 to 999; y <- 100 to 999 if (isPalindrome(x * y))) yield x*y
	    println(palindromes.max)
	}
}

