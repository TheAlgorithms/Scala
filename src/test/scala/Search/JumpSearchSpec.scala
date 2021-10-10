package Search

import org.scalatest.flatspec.AnyFlatSpec

class JumpSearchSpec extends AnyFlatSpec {
  "A Jump Search" should "return the index of an element in an array" in {
    val l = List.range(1, 10)
    assert(JumpSearch.jumpSearch(l, 2) == 1)
    assert(JumpSearch.jumpSearch(l, 5) == 4)
  }

  it should "return -1 if the element is not present in the list" in {
    val l = List.range(1, 10)
    val m = List(1, 3, 5, 7)
    assert(JumpSearch.jumpSearch(l, 12) == -1)
    assert(JumpSearch.jumpSearch(l, -3) == -1)
    assert(JumpSearch.jumpSearch(m, 4) == -1)
    assert(JumpSearch.jumpSearch(m, 8) == -1)
    assert(JumpSearch.jumpSearch(m, 0) == -1)
  }
}
