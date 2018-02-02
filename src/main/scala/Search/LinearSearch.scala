package Search

/**
  * This is scala implementation of linear search algorithm
  */
object LinearSearch {
  /**
    *
    * @param arr   - a sequence of integers
    * @param elem - a integer to search for in the @args
    * @return - index of the @elem or -1 if elem is not fount in the @arr
    */
  def linearSearch(arr: List[Int], elem: Int): Int = {
    //the functional way, common in scala would be:
    //args.indexOf(target)
    for (i <- arr.indices if (arr(i) == elem)) {
        return i
    }
    -1
  }

}