package Mathematics

object DecOctBinConverter {

  //convert Int to Dec
  def decimalConverter(n: Int): Int = {
    var value = 0
    var multiplier = 1
    var num = n


    while (num > 0) {
      value = value + ((num % 10) * multiplier)
      num = num / 10
      multiplier = multiplier * 10
    }

    return value
  }

  //convert Int to Oct
  def octalConverter(n:Int): Int = {
    var value = 0
    var multiplier = 1
    var num = n


    while (num > 0) {
      value = value + ((num % 8) * multiplier)
      num = num / 8
      multiplier = multiplier * 10
    }

    return value
  }

  //convert Int to Bin
  def binaryConverter(n: Int): Int = {
    var value = 0
    var multiplier = 1
    var num = n


    while (num > 0) {
      value = value + ((num % 2) * multiplier)
      num = num / 2
      multiplier = multiplier * 10
    }

    return value
  }

}