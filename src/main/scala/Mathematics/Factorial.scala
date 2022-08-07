object getFactorial
{
    // Iterative way to get factorial
    def factorial(x: Int): Int = {
          
        var f = 1
        for(i <- 1 to x)
        {
            f = f * i;
        }
          
        return f
    }

    // Recursive way to get factorial
    def factorial(y: Int): Int =
    {
        if (y == 0) 
            return 1
        else
            return y * factorial(y-1)
    }
  
}
