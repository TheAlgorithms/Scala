package Graph;

/**
 * Find the shortest path in directed graph.
 *
 * Reference: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */
object Dijkstra {

   class Vertice {
       label: String
       adjentEdges: List[Edge]
   }

   class Edge {
       dest: Vertice
       weight: Integer
   }

   /**
    *
    *
    */
   def search(graph: List[Vertice], source: Vertice, dest: Vertice): List[Vertice] {

   }

}