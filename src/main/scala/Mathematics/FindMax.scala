package Mathematics

object FindMax {

	/**
	    * Method returns Max Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/
	def findMax(elements: Int*): Int = elements.foldLeft(elements.head){(acc, i) => if (acc > i) acc else i}
}
