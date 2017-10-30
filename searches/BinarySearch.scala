object BinarySearch {
	def search(ds: Array[Double], key: Double): Option[Int] = {
		@tailrec
		def run(lo: Int, hi: Int): Option[Int] = {
			if (lo > hi)
				None
			else {
				val mid: Int = lo + (hi - lo) / 2
				ds(mid) match {
					case mv if (mv == key) => Some(mid)
					case mv if (mv <= key) => run(mid + 1, hi)
					case _ => run(lo, mid - 1)
				}
			}
		}
		run(0, ds.size - 1)
	}
}
