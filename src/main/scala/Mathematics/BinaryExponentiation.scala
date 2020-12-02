package Mathematics

object BinaryExponentiation {
	/**
	    * Method returns the binary exponentiation of a given number 
	      when base and power are passed the parameters
	    *
	    * @param base the base to use
			* @param power the power to raise it to
		  * @return the binary exponentiation of the given number
    	*/
	
	def binaryExponentiation(base : Int, power : Int): Int = {
		power match {
			case _==0 => 1
			case _%2==1 => binaryExponentiation(base, power - 1) * base
			case _ =>
				val answer: Int = binaryExponentiation(base, power / 2)
				answer * answer
		}
	}
} 
