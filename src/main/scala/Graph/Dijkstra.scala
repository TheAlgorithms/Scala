package Graph;

/**
  * Find the shortest path in directed graph.
  *
  * Reference: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
  */
object Dijkstra {

  type VerticeLabel = String
  type EdgeWeight = Integer

  case class Vertice(label: VerticeLabel, distance: Map[VerticeLabel, EdgeWeight]);

  def search(
      graph: List[VerticeLabel],
      source: VerticeLabel,
      dest: VerticeLabel
  ): List[VerticeLabel] = {
    List()
  }

}
