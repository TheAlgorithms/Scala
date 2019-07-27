package Array

import org.scalatest.FlatSpec

class MinimumStepInInfiniteGridSpec {

    "Minimum Step In Infinite Grid should return the minimum number of steps taken to follow the given coordinates" in {
          assert(MinimumStepInInfiniteGrid.minimumSteps(Array(0, 1, 1), Array(0, 1, 2)) === 2 
    }

    "Minimum Step In Infinite Grid should return the minimum number of steps taken to follow the given coordinates" in {
          assert(MinimumStepInInfiniteGrid.minimumSteps(Array(0, 1, 7, 9), Array(1, 1, 1, 6)) === 12
    }

}
