package ProjectEuler

object Euler3 {
    /** 
	*Problem Statement : The prime factors of 13195 are 5, 7, 13 and 29.

	*What is the largest prime factor of the number 600851475143 ?

    **/

	def primeFactors(num: Long): List[Long] = {
            val exists = (2L to math.sqrt(num).toLong).find(num % _ == 0)
            exists match {
		case None => List(num)
                case Some(d) => d :: primeFactors(num/d)
            }
    }

	def main(args : Array[String]) {
	    println(primeFactors(600851475143L).last)
        }
}
