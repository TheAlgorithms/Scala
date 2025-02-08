package Mathematics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class AreaSpec extends AnyFlatSpec {

  "A circle with radius 4.679" should "output the correct Float result" in {
    assert(Area.areaCircle(4.679) === 68.77902f)
  }

  "A circle with radius -1" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaCircle(-1)
    }
    assert(caught.getMessage == "areaCircle() only accepts non-negative values")
  }

  "An ellipse with radiusX 9.375 and radiusY 7.354" should "output the correct Float result" in {
    assert(Area.areaEllipse(9.375, 7.354) === 216.59318f)
  }

  "An ellipse with radiusX -2 and radiusY -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaEllipse(-2, -5)
    }
    assert(caught.getMessage == "areaEllipse() only accepts non-negative values")
  }

  "A parallelogram with height 17.497 and base 15.368" should "output the correct Float result" in {
    assert(Area.areaParallelogram(17.497, 15.368) === 268.8939f)
  }

  "A parallelogram with height -2 and base -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaParallelogram(-2, -5)
    }
    assert(caught.getMessage == "areaParallelogram() only accepts non-negative values")
  }

  "A rhombus with diagonal1 26.758 and diagonal2 75.739" should "output the correct Float result" in {
    assert(Area.areaRhombus(26.758, 75.739) === 1013.31208f)
  }

  "A rhombus with diagonal1 -2 and diagonal2 -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaRhombus(-2, -5)
    }
    assert(caught.getMessage == "areaRhombus() only accepts non-negative values")
  }

  "A rectangle with height 47.857 and width 95.365" should "output the correct Float result" in {
    assert(Area.areaRectangle(47.857, 95.365) === 4563.8828f)
  }

  "A rectangle with height -2 and width -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaRectangle(-2, -5)
    }
    assert(caught.getMessage == "areaRectangle() only accepts non-negative values")
  }

  "A square with length 85.352" should "output the correct Float result" in {
    assert(Area.areaSquare(85.352) === 7284.9639f)
  }

  "A square with length -2" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaSquare(-2)
    }
    assert(caught.getMessage == "areaSquare() only accepts non-negative values")
  }

  "A triangle with height of 10.395 and length of 5.944" should "output the correct Float result" in {
    assert(Area.areaTriangle(10.395, 5.944) === 30.89394f)
  }

  "A triangle with height of -4 and length of -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaTriangle(-4, -5)
    }
    assert(caught.getMessage == "areaTriangle() only accepts non-negative values")
  }

  "A trapezium with base1 85.352, base2 75.879 and height 62.869" should "output the correct Float result" in {
    assert(Area.areaTrapezium(85.352, 75.879, 62.869) === 5068.21587f)
  }

  "A trapezium with base1 -1, base2 -2 and height -3" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      Area.areaTrapezium(-1, -2, -3)
    }
    assert(caught.getMessage == "areaTrapezium() only accepts non-negative values")
  }
}
