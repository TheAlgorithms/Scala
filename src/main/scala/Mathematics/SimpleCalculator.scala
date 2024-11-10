package Mathematics
 
object Calculator 
{
  def add(a: Int, b: Int): Int = a+b
  
  def substract(a: Int, b: Int): Int = a-b
  
  def multiply(a: Int, b: Int): Long = a*b
  
  def division(a: Int, b: Int): Int = 
  {
    require(b != 0, "Denominator can not be 0")    
    a/b
  }
}