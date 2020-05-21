package Mathematics

object AbsMin {

	/**
	    * Method returns Absolute minimum Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/
	def absMin(elements : List[Int]): Int = Abs.abs(elements.minBy(x => Abs.abs(x)))

}
