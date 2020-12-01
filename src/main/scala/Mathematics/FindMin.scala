package Mathematics

object FindMin {

	/**
	    * Method returns Minimum Element from the list
	    *
	    * @param elements the list to find the min element for
    	    * @return the minimum element in the list
    	*/
	def findMin(elements : List[Int]): Int = elements.foldLeft(elements.head){(acc, i) => if (acc < i) acc else i}
}
