package Array

object MinimumStepInInfiniteGrid {
    
    /**
	    * Method returns minimum numbers of steps
	    *
	    * @param Array[Int], @param Array[Int]
    	    * @return
    */
     
    def minimumSteps(x_coordinate: Array[Int], y_coordinate: Array[Int]): Int  = {
        var steps = 0
        for (i <- 1 until x.coordinate.length) {
            val x_direction = math.abs(x_coordinate(i) - x_coordinate(i - 1))
            val y_direction = math.abs(y_coordinate(i) - y_coordinate(i - 1))
            steps = steps + math.max(x_direction, y_direction)
        }
        steps
    }
}
