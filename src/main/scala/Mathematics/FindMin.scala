package Mathematics

object FindMin {

	/**
	    * Method returns Minimum Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/

	def findMin(Elements : List[Int]): Int = {
	    var length : Int = Elements.length;
	    var min : Int = Elements(0)
	    for (i <- 1 to length -  1) {
		if (min > Elements(i)) {
			min = Elements(i);
		}
	    }
	    return min;
	}
}
