package Mathematics

import scala.math.abs

object AbsMax {

	/**
	    * Method returns absolute Maximum Element from the list
	    *
	    * @param listOfElements
    	    * @return
    	*/
	def absMax(elements : Int*): Int = abs(elements.maxBy(x => abs(x)))

}
