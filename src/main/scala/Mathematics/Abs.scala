package Mathematics

object Abs {

	/**
	    * Method returns Max Element from the list
	    *
	    * @param Int
    	    * @return
    	*/

	def abs(number : Int): Int = {
	    if (number < -1) {
		return number * -1
	    }
	    return number;
	}
}
