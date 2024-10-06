package Mathematics

object PythagoreanTheorem {

    /** Returns two dimension distant */
    def distance(x: Double, y: Double): Double = {
      Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) 
    }
}