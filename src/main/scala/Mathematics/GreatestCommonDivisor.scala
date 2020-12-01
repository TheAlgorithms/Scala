package Mathematics

import scala.annotation.tailrec

object GreatestCommonDivisor {

	/**
	    * Method returns the Greatest Common Divisor of two numbers n, m
	    *
	    * @param n the first number
		  * @param m the second number
    	    * @return the greatest common divisor of n and m
    	*/

	@tailrec
	def gcd(n: Long, m: Long): Long = if (m == 0) n else gcd(m, n % m)
  
}
