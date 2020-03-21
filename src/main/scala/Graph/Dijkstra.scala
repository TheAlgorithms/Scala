package Graph;

import scala.collection.mutable

/**
  * Find the shortest path in directed graph.
  *
  * Reference: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
  */
object Dijkstra {

  type VERTEX_LABEL = String
  type EDGE_WEIGHT = Int
  type PATH = List[VERTEX_LABEL]

  case class Vertex(
      label: VERTEX_LABEL,
      distance: Map[VERTEX_LABEL, EDGE_WEIGHT]
  ) {
    def ===(that: Vertex): Boolean = this.label.equals(that.label)
  }

  type GRAPH = List[Vertex]

  /**
    * Find the shortest from source to destination on graph
    *
    * @param graph  Directed graph
    * @param source From vertex
    * @param destination To vertex
    *
    * @return Shortest path as list of vertices
    */
  def search(
      graph: GRAPH,
      source: Vertex,
      destination: Vertex
  ): PATH = {

    // edge case where source and destination is identical
    if (source === destination) return List(source.label)

    val distanceMap: mutable.Map[Vertex, EDGE_WEIGHT] =
      mutable.Map(graph.map(_ -> Int.MaxValue): _*)
    distanceMap(source) = 0

    val parentMap: mutable.Map[Vertex, Vertex] = mutable.Map.empty
    parentMap(source) = source

    val notVisitedVertices: mutable.Set[Vertex] = mutable.Set(graph: _*)
    var nearestVertex: Vertex = null;

    while ((!notVisitedVertices.isEmpty) && (destination != nearestVertex)) {

      // find nearest vertex
      nearestVertex = notVisitedVertices
        .map(v => (v, distanceMap(v)))
        .minBy(_._2)
        ._1

      // remove nearest vertex from not visited vertices
      notVisitedVertices.remove(nearestVertex)

      if (nearestVertex != destination) {

        // update not visited vertex distances based on the nearest one
        notVisitedVertices.foreach(vertex => {

          val newPathDistance = distanceMap(nearestVertex) +
            nearestVertex.distance
              .getOrElse(
                vertex.label,
                Int.MaxValue - distanceMap(nearestVertex)
              )

          // if a better path is found
          if (distanceMap(vertex) > newPathDistance) {
            distanceMap(vertex) = newPathDistance
            parentMap(vertex) = nearestVertex
          }

        })
      }
    }

    var shortestPath: PATH = List.empty
    var node: Vertex = destination

    while (node.label != source.label) {
      shortestPath = shortestPath.+:(node.label)
      node = parentMap(node)
    }

    List(source.label):::shortestPath

  }

}
