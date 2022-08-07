package Mathematics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._



class surfaceAreaSpec extends AnyFlatSpec {

  "A sphere with radius 4.679" should "output the correct Float result" in {

    assert(surfaceArea.surfaceAreaSphere(4.679) === 275.11606f)
  }

  "A sphere with radius -1" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      surfaceArea.surfaceAreaSphere(-1)
    }
    assert(caught.getMessage == "surfaceAreaSphere() only accepts non-negative values")
  }

  "A cuboid with length 8.375 , height 7.354 and breadth 7.354 " should "output the correct Float result" in {
    assert(surfaceArea.surfaceAreaCuboid(8.375, 7.354,7.354) === 354.52163f)
  }

  "A cuboid with length -2, height -5, breadth -10" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      surfaceArea.surfaceAreaCuboid(-2, -5,-10)
    }
    assert(caught.getMessage == "surfaceAreaCuboid() only accepts non-negative values")
  }

  "A cube with side 5" should "output the correct Float result" in {
    assert(surfaceArea.surfaceAreaCube(150) == 150.0000f)
  }

  "A cube with side -2" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      surfaceArea.surfaceAreaCube(-2)
    }
    assert(caught.getMessage == "surfaceAreaCube() only accepts non-negative values")
  }

  "A right prism with side 29.888 and height 25.739" should "output the correct Float result" in {
    assert(surfaceArea.surfaceAreaRightPrism(29.888, 25.739) === 2970.35781f)
  }

  "A right prism with side -2 and height -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      surfaceArea.surfaceAreaRightPrism(-2, -5)
    }
    assert(caught.getMessage === "surfaceAreaRightPrism() only accepts non-negative values")
  }

  "A right cylinder with height 7.857 and width 15.365" should "output the correct Float result" in {
    assert(surfaceArea.surfaceAreaCylinder(7.857, 15.365) == 1146.40017f)
  }

  "A right cylinder with height -2 and width -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      surfaceArea.surfaceAreaCylinder(-2, -5)
    }
    assert(caught.getMessage === "surfaceAreaCylinder() only accepts non-negative values")
  }

  "A right pyramid with side 5.352 and height 7.872" should "output the correct Float result" in {
    assert(surfaceArea.surfaceAreaPyramid(5.352,7.872) === 117.6413f)
  }

  "A right pyramid with side -3 and height -4" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      surfaceArea.surfaceAreaPyramid(-3,-4)
    }
    assert(caught.getMessage === "surfaceAreaPyramid() only accepts non-negative values")
  }

  "A right circular cone with length of 10.395 and radius of 5.944" should "output the correct Float result" in {
    assert(surfaceArea.surfaceAreaCone(10.395, 5.944) === 30.89394f)
  }

  "A right circular cone with length of -4 and radius of -5 shouldn output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      surfaceArea.surfaceAreaCone(-4, -5)
    }
    assert(caught.getMessage === "surfaceAreaCone() only accepts non-negative values")
  }

  
}