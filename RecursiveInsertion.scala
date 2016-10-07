/**
 * Created by Nikogiannis on 6/10/2016.
 */

object RecursiveInsertion {

  def main(args: Array[String]) {
    //input Like The Original Insertion Algorithm
    val array= new Array[Int](6);

    //Input
    println("Enter any 6 Numbers for Unsorted Array : ");
    for(i <- 0 to 5)
    {
      array(i)=scala.io.StdIn.readInt();
    }

    //insertion and Output

    insertion(array.toList).foreach(println)
  }

  def insertion(x:List[Int]) :List[Int]={
    x match {
      case List() => List()
      case x :: xs => ins(x, insertion(xs))
    }
  }

  def ins(x:Int,xs: List[Int]): List[Int]={
    xs match{
      case List()=>List(x)
      case x2::xs2 => if(x<=x2) x::xs else x2::ins(x,xs2)
    }
  }


}
