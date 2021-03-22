package Array

object MaximumAbsoluteDifference {

    /**
	    * You are given an array of N integers. Return maximum value for all 1 ≤ i, j ≤ N,
        which is defined as |array[i] - array[j]| + |i - j|, where |x| denotes absolute value of x.
	    *
	    * @param Array[Int]
    	    * @return
    	*/

    def maxAbsDiff(array : Array[Int]): Int  = {
    
        var maximum_sum = Int.MinValue
        var maximum_difference = Int.MinValue
        var minimum_sum = Int.MaxValue
        var minimum_difference = Int.MaxValue
        for (i <- array.indices) {
            val value = array(i)
            sum(i) = value + i
            difference(i) = ai - i
        }
    
        Math.max(
          sum.max - sum.min,
          Math.abs(difference.max - difference.min)
        )
    }
}
