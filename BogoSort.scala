import util.Random

object BogoSort
{
	 def CheckIfSorted(args : Array[Int],  size:Int):Int=
	{
		for(i <- 0 to size-1)
		{
			if(args(i)>args(i+1))
			return 0
		}
		return 1
	}

	def shuffle(args: Array[Int], size:Int)
	{
		var r:Int=0;
		var t:Int=0;
		for(i <- 0 to size)
		{
			// println(args(i))
			t=args(i);
			r=((Random.nextInt(100))%size)
			// println(r)
			args(i)=args(r);
			args(r)=t;
		}
	}

	def main(args : Array[String])
	{
	var array=new Array[Int](6);
	println("Enter 6 unsorted numbers : ");

	// Input
	for(i <- 0 to 5)
	{
		array(i)=scala.io.StdIn.readLine().toInt;
	}

	// Sorting
	while( CheckIfSorted(array, 5)!=1)
	{
		shuffle(array, 5);
	}

	println("\nSorted Array : ")
	for(i <- 0 to 5)
	{
		println(array(i));
	}
}
}
