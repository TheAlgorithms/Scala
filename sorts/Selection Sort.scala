

object SelectionSort {
  def main(args : Array[String])
  {
    var array= new Array[Int](6);
   
    //Input
    println("Enter any 6 Numbers for Unsorted Array : ");
    for(i <- 0 to 5)
    {
      array(i)=scala.io.StdIn.readLine().toInt;
    }
    
    //Sorting
    for(i <- 0 to 5)
    {
      var min: Int =i;
      for(j <- i+1 to 5)
      {
        if(array(j) < array(i))
        {
          min=j;
        }
      }
      var temp: Int = array(i);
      array(i)=array(min);
      array(min)=temp;
    }
    
    //Output
    for(i <- 0 to 5)
    {
      print(array(i)+"\t");
    }
  }
}