package Mathematics

import scala.math.{Pi, pow}

object Area {

  /** Calculates the area of a circle
    * @param radius
    *   - a double to retrieve the radius of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaCircle(radius: Double): Float = {
    if (radius < 0) throw new IllegalArgumentException("areaCircle() only accepts non-negative values")
    return Pi.toFloat * pow(radius, 2).toFloat
  }

  /** Calculates the area of an ellipse
    * @param radiusX
    *   - a double to retrieve x-axis radius of object
    * @param radiusY
    *   - a double to retrieve y-axis radius of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaEllipse(radiusX: Double, radiusY: Double): Float = {
    if (radiusX < 0 || radiusY < 0)
      throw new IllegalArgumentException("areaEllipse() only accepts non-negative values")
    return (Pi * radiusX * radiusY).toFloat
  }

  /** Calculates the area of a parallelogram
    * @param height
    *   - a double to retrieve the height of object
    * @param base
    *   - a double to retrieve the base of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaParallelogram(height: Double, base: Double): Float = {
    if (height < 0 || base < 0)
      throw new IllegalArgumentException("areaParallelogram() only accepts non-negative values")
    return (height * base).toFloat
  }

  /** Calculates the area of a rhombus
    * @param diagonal1
    *   - a double to retrieve the first diagonal (vertical/horizontal) of object
    * @param diagonal2
    *   - a double to retrieve the second diagonal (vertical/horizontal) of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaRhombus(diagonal1: Double, diagonal2: Double): Float = {
    if (diagonal1 < 0 || diagonal2 < 0)
      throw new IllegalArgumentException("areaRhombus() only accepts non-negative values")
    return (diagonal1 * diagonal2 / 2).toFloat
  }

  /** Calculates the area of a rectangle
    * @param height
    *   - a double to retrieve the height of object
    * @param width
    *   - a double to retrieve the width of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaRectangle(height: Double, width: Double): Float = {
    if (height < 0 || width < 0)
      throw new IllegalArgumentException("areaRectangle() only accepts non-negative values")
    return (height * width).toFloat
  }

  /** Calculates the area of a square
    * @param length
    *   - a double to retrieve the length of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaSquare(length: Double): Float = {
    if (length < 0) throw new IllegalArgumentException("areaSquare() only accepts non-negative values")
    return pow(length, 2).toFloat
  }

  /** Calculates the area of a triangle
    * @param height
    *   - a double to retrieve the height of object
    * @param base
    *   - a double to retrieve the base of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaTriangle(height: Double, base: Double): Float = {
    if (height < 0 || base < 0)
      throw new IllegalArgumentException("areaTriangle() only accepts non-negative values")
    return ((height * base) / 2).toFloat
  }

  /** Calculates the area of a trapezium
    * @param base1
    *   - a double to retrieve the first base length of object
    * @param base2
    *   - a double to retrieve the second base length of object
    * @param height
    *   - a double to retrieve the height of object
    * @return
    *   - a float that returns the area of object or an exception for invalid input
    */
  def areaTrapezium(base1: Double, base2: Double, height: Double): Float = {
    if (height < 0 || base1 < 0 || base2 < 0)
      throw new IllegalArgumentException("areaTrapezium() only accepts non-negative values")
    return ((base1 + base2) * height / 2).toFloat
  }
}
