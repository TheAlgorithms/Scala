package Mathematics

object PrimeFactors {

	/**
	    * Method returns list of prime factors of number n
	    *
	    * @param num
    	    * @return
    	*/

	def primeFactors(number: Long): List[Long] = {
	    val exists = (2L to math.sqrt(number).toLong).find(number % _ == 0)
	    exists match {
      		case Some(factor) => factor :: primeFactors(number/factor)
      		case None => List(number)
    		}
  	}
}
