package Mathematics

object BinaryExponentiation {
	/**
	    * Method returns the binary exponentiation of a given number 
	      when base and power are passed the parameters
	    *
	    * @param Int, Int
    	    * @return
    	*/
	
	def BinaryExponentiation(base : Int, power : Int): Int = {
    		if (power == 0) {
        		return 1
		} else if (power % 2 == 1) {
        		return BinaryExponentiation(base, power - 1) * base
		} else {
        		var answer : Int= BinaryExponentiation(base, power / 2)
        		return answer * answer
		}
	}
} 
