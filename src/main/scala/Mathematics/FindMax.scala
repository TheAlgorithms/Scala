package Mathematics

object FindMax {

	/**
	    * Method returns Max Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/

	def findMax(Elements : List[Int]): Int = {
	    var length : Int = Elements.length;
	    var max : Int = Elements(0)
	    for (i <- 1 to length -  1) {
		if (max < Elements(i)) {
			max = Elements(i);
		}
	    }
	    return max;
	}
}
