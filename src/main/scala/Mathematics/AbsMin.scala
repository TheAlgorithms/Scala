package Mathematics

import math.abs

object AbsMin {

	/**
	    * Method returns Absolute minimum Element from the list
	    *
	    * @param elements the list to consider
    	    * @return the absolute value of the minimum element in the list
    	*/
	def absMin(elements : List[Int]): Int = abs(elements.minBy(x => abs(x)))

}
