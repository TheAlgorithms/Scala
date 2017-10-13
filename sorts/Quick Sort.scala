object QuickSort
{
	def Sort(array:Array[Int], first:Int, last:Int)
	{
		 var pivot:Int=0;
		 var i:Int=0;
		 var j:Int=0;
		 var temp:Int=0;

		 if(first < last)
		 {
		 	pivot=first;
		 	i=first;
		 	j=last;

		 	while (i < j)
		 	{
				while(array(i)<=array(pivot) && i<last)
	 			{
	 				i+=1;
	 			}
		
	 			while(array(j)>array(pivot))
	 			{
	 				j-=1;
	 			}
		
	 			if(i<j)
	 			{
	 				temp=array(i);
	 				array(i)=array(j);
	 				array(j)=temp;
	 			}
			}

		 	temp=array(pivot);
		 	array(pivot)=array(j);
		 	array(j)=temp;
		 	Sort(array, first, j-1);
		 	Sort(array, j+1, last);
		 }

	}

	def main(args: Array[String])
	{
		var size: Int=20;
		var array=new Array[Int](20);

		// Input
		println("Enter the size of Unsorted Array : ");
		size=scala.io.StdIn.readLine().toInt;
		println("Enter the Unsorted Array : ");
		for(i <- 0 to size-1)
		{
			array(i)=scala.io.StdIn.readLine().toInt;
		}

		Sort(array, 0, size-1);

		// Output
		println("Sorted array : ");
		for(i <- 0 to size-1)
		{
			println(array(i));
		}
	}
}