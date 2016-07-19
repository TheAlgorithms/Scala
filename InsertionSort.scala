

object InsertionSort {
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
    	var temp:Int=array(i);
    	var j=i-1;
     	while(j>=0 && temp<array(j))
    	{
    		array(j+1)=array(j);
    		j-=1;
     	}
     	array(j+1)=temp;
    }
    
    //Output
    for(i <- 0 to 5)
    {
      print(array(i)+"\t");
    }
  }
}