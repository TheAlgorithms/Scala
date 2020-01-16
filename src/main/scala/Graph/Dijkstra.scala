package Graph;

/**
 * Find the shortest path in directed graph.
 *
 * Reference: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */
object Dijkstra {



   case class Vertice(label: String, distance: Map[String,Integer]);


   def search(graph: List[Vertice], source: String, dest: String): List[String] = {
     List()
   }

}