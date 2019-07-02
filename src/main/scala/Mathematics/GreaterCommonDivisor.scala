package Mathematics

object GreaterCommonDivisor {

	/**
	    * Method returns list of prime factors of number n
	    *
	    * @param num1, num2
    	    * @return
    	*/

	def gcd(num1: Long, num2: Long): Long = {
    		if (num2 == 0) num1
    		else gcd(num2, num1 % num2)
  	}
  
}
