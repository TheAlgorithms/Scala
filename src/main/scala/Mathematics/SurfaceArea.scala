package Mathematics

import scala.math.{Pi, pow}

object SurfaceArea {

  /** Calculates the total surface area of a sphere
    * @param radius
    *   - a double to retrieve the radius of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def surfaceAreaCircle(radius: Double): Float = {
    if (radius < 0) throw new IllegalArgumentException("surfaceAreaCircle() only accepts non-negative values")
    return  4 * Pi.toFloat * pow(radius, 2).toFloat
  }

  /** Calculates the total surface area of cuboid
    * @param length
    *   - a double to retrieve length of object
    * @param height
    *   - a double to retrieve height of object
    * @param breadth
    *   - a double to retrieve breadth of object
    * @return
    *   - a float that returns the surface area of object or an exception for invalid input
    */
  def surfaceAreaCuboid(length: Double, height: Double,breadth:Double): Float = {
    if (length< 0 || height < 0||breadth <0)
      throw new IllegalArgumentException("surfaceAreaCuboid() only accepts non-negative values")
    return (2 *((length*breadth)+(breadth*height)+(length*height))).toFloat
  }

  /** Calculates the total surface area of cube
    * @param side
    *   - a double to retrieve side of object
    * @return
    *   - a float that returns the surface area of object or an exception for invalid input
    */
  def surfaceAreaCube(side: Double): Float = {
    if (side<0)
      throw new IllegalArgumentException("surfaceAreaCube() only accepts non-negative values")
   return (6 * pow(side, 2)).toFloat
  }

  

   /** Calculates the total surface area of a right circular cylinder
    * @param radius
    *   - a double to retrieve the radius of object
    * @param height
    *   - a double to retrieve the height of object
    * @return
    *   - a float that returns the surface area of object or an exception for invalid input
    */
   def surfaceAreaCylinder(radius: Double, height: Double): Float = {
    if (radius< 0 || height < 0)
      throw new IllegalArgumentException("surfaceAreaCyclinder() only accepts non-negative values")
    return (2*Pi*radius*(radius+height)).toFloat
  }

  /** Calculates the surface area of a right pyramid
    * @param side
    *   - a double to retrieve the side of object
    * @param height
    *   - a double to retrieve the height of object
    * @return
    *   - a float that returns the surface area of object or an exception for invalid input
    */
   def surfaceAreaPyramid(side: Double, height:Double): Float = {
    if (side < 0 || height < 0) throw new IllegalArgumentException("surfaceAreaPyramid() only accepts non-negative values")
    return (0.5*((side*4)*height)).toFloat + pow(side, 2).toFloat
  }

   /** Calculates the surface area of right circular cone
    * @param length
    *   - a double to retrieve the length of object
    * @param radius
    *   - a double to retrieve the radius of object
    * @return
    *   - a float that returns the surface area of object or an exception for invalid input
    */
 def surfaceAreaCone(length: Double, radius: Double): Float = {
     if (length < 0 || radius < 0)
      throw new IllegalArgumentException("surfaceAreaCone() only accepts non-negative values")
    return Pi.toFloat*radius.toFloat * (length+radius).toFloat
  }

  
}