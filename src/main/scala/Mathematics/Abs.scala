package Mathematics

object Abs {

	/**
	    * Method returns absolute value of the number
	    *
	    * @param number the number to find the abs value for
    	    * @return the abs value of number
    	*/

	def abs(number : Int): Int = if (number < 0) number * -1 else number
}
