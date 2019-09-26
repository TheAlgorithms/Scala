package Mathematics

import math._

object AbsMin {

	/**
	    * Method returns Absolute minimum Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/
	def absMin(elements: Int*): Int = abs(elements.minBy(x => abs(x)))

}
