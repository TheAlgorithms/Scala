package Mathematics

object AbsMin {

	/**
	    * Method returns Absolute minimum Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/
	
	def absMin(Elements : List[Int]): Int = {
	    var length : Int = Elements.length;
	    var min : Int = Elements(0)
	    for (i <- 1 to length -  1) {
		if (Math.abs(min) > Math.abs(Elements(i))) {
			min = Elements(i);
		}
	    }
	    return min;
	}
}
