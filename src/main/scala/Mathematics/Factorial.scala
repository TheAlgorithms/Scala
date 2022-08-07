object Factorial
{
    // Iterative way to get factorial
    def factorialIterative(x: Int): Int = {
          
        var f = 1
        for(i <- 1 to x)
        {
            f = f * i;
        }
          
        return f
    }

    // Recursive way to get factorial
    def factorialRecursive(y: Int): Int =
    {
        if (y == 0) 
            return 1
        else
            return y * factorialRecursive(y-1)
    }
  
}
