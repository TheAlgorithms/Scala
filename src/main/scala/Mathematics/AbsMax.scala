package Mathematics

import math.abs

object AbsMax {

	/**
	    * Method returns absolute Maximum Element from the list
	    *
	    * @param elements the list to consider
    	    * @return the absolute value of the maximum element in the list
    	*/
	def absMax(elements : List[Int]): Int = abs(elements.maxBy(x => abs(x)))

}
