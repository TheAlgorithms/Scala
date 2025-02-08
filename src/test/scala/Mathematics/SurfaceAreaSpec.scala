package Mathematics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class SurfaceAreaSpec extends AnyFlatSpec {

  "A sphere with radius 4.679" should "output the correct Float result" in {
    assert(SurfaceArea.surfaceAreaSphere(4.679) === 275.11607f)
  }

  "A sphere with radius -1" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      SurfaceArea.surfaceAreaSphere(-1)
    }
    assert(caught.getMessage == "surfaceAreaSphere() only accepts non-negative values")
  }

  "A cuboid with length 8.375 , height 7.354 and breadth 7.354 " should "output the correct Float result" in {
    assert(SurfaceArea.surfaceAreaCuboid(8.375, 7.354,7.354) === 354.52163f)
  }

  "A cuboid with length -2, height -5, breadth -10" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      SurfaceArea.surfaceAreaCuboid(-2, -5,-10)
    }
    assert(caught.getMessage == "surfaceAreaCuboid() only accepts non-negative values")
  }

  "A cube with side 5" should "output the correct Float result" in {
    assert(SurfaceArea.surfaceAreaCube(5) === 150.0000f)
  }

  "A cube with side -2" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      SurfaceArea.surfaceAreaCube(-2)
    }
    assert(caught.getMessage == "surfaceAreaCube() only accepts non-negative values")
  }



  "A right cylinder with radius 7.857 and height 15.365" should "output the correct Float result" in {
    assert(SurfaceArea.surfaceAreaCylinder(7.857, 15.365) === 1146.40017f)
  }

  "A right cylinder with radius -2 and height -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      SurfaceArea.surfaceAreaCylinder(-2, -5)
    }
    assert(caught.getMessage == "surfaceAreaCylinder() only accepts non-negative values")
  }

  "A right pyramid with side 5.352 and height 7.872" should "output the correct Float result" in {
    assert(SurfaceArea.surfaceAreaPyramid(5.352,7.872) === 117.64131f)
  }

  "A right pyramid with side -3 and height -4" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      SurfaceArea.surfaceAreaPyramid(-3,-4)
    }
    assert(caught.getMessage == "surfaceAreaPyramid() only accepts non-negative values")
  }

  "A right circular cone with length of 10.395 and radius of 5.944" should "output the correct Float result" in {
    assert(SurfaceArea.surfaceAreaCone(10.395, 5.944) === 334.60221f)
  }

  "A right circular cone with length of -4 and radius of -5" should "output the correct exception result" in {
    val caught = intercept[IllegalArgumentException] {
      SurfaceArea.surfaceAreaCone(-4, -5)
    }
    assert(caught.getMessage == "surfaceAreaCone() only accepts non-negative values")
  }

  
}