package Mathematics

object AbsMax {

	/**
	    * Method returns absolute Max Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/

	def absMax(Elements : List[Int]): Int = {
	    var length : Int = Elements.length;
	    var max : Int = Elements(0)
	    for (i <- 1 to length -  1) {
		if (Math.abs(max) < Math.abs(Elements(i))) {
			max = Elements(i);
		}
	    }
	    return max;
	}
}
