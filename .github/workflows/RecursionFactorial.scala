def factorial(n: Int): Int = {
  if (n == 0) 1
  else n * factorial(n - 1)
}

val n = 5
println(s"Factorial of $n is ${factorial(n)}")
