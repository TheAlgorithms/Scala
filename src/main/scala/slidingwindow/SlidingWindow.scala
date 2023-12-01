package slidingwindow

object SlidingWindow {

  /** Method returns absolute value of the number
    *
    * @param Int
    * @return
    */
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    val res = nums.filter(_ != `val`)
    res.indices.foldLeft(nums) { (nums, i) =>
      nums(i) = res(i)
      nums
    }
    res.length
  }
  
}
