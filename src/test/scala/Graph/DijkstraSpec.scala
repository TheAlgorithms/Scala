package Graph;

import org.scalatest.FlatSpec

import Graph.Dijkstra.Vertex
import Graph.Dijkstra.GRAPH

class DijkstraSpec extends FlatSpec {

  /**

    Graph 1

        9         2          1
    +-------> B+-----> D +-------+
    |         +        ^         |
    +         |        |         v
    A         |        | 3       F
    +       1 |        |         ^
    |         |        |         |
    |         v        +         |
    +-------> C+-----> E +-------+
        3         4          5

    Shortest path from A to F: A->C->E->D-F = 3+4+3+1 = 11
    */
  "Dijkstra Algorithm" should "return the shortest paths in graph 1" in {

    val A: Vertex = Vertex("A", Map("B" -> 9, "C" -> 3))
    val B: Vertex = Vertex("B", Map("D" -> 2, "C" -> 1))
    val C: Vertex = Vertex("C", Map("E" -> 4))
    val D: Vertex = Vertex("D", Map("F" -> 1))
    val E: Vertex = Vertex("E", Map("D" -> 3, "F" -> 5))
    val F: Vertex = Vertex("F", Map.empty)

    val graph: GRAPH = List(A, B, C, D, E, F)

    assert(Dijkstra.search(graph, A, F) === List(A, C, E, D, F).map(_.label))
    assert(Dijkstra.search(graph, B, F) === List(B, D, F).map(_.label))

  }

}
