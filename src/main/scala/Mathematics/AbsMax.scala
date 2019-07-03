package Mathematics

object AbsMax {

	/**
	    * Method returns absolute Maximum Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/

	def absMax(elements : List[Int]): Int = {
	    var length : Int = elements.length;
	    var max : Int = elements(0)
	    for (i <- 1 to length -  1) {
		if (Math.abs(max) < Math.abs(elements(i))) {
			max = elements(i);
		}
	    }
	    return max;
	}
}
