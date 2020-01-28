package com.srikar.ds.graph;

import java.util.*;

public class Graph {

    private List<Vertex> vertices = new ArrayList<>();
    private Map<Edge, Integer> edges = new HashMap<>();

    public Graph() {
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex source, Vertex destination, int distance) {
        edges.put(new Edge(source, destination), distance);
    }

    class Vertex {
        private String name;

        private Vertex(String name) {
            this.name = name;
        }
    }

    class Edge {
        private Vertex source;
        private Vertex destination;
        private int distance;

        private Edge(Vertex source, Vertex destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    /**
     * dijkstraAlgorithm (Vertex source, Graph graph) :
     *
     * 	initialize visited: []
     * 	initialize vertexToDistances: <Vertex, Distance {distance, prevVertex}>
     * 	initialize vertexQueue: <Vertex>
     *
     * 	iterate graphs.vertices
     * 		initialize vertexToDistances : <vertex, (INFINITY, null)>
     *
     * 		update vertexToDistances : <source, (0, null)>
     * 		add vertexQueue : <source>
     *
     * 	iterate queue until empty
     * 		initialize root: pop vertexQueue.min
     * 		initialize minDistance : INFINITY
     * 		initialize minVertex : null
     *
     * 		visited.add :: root
     *
     * 		iterate root.edges -> edge
     *
     * 			initialize adjacent : edge.adjacent
     * 			initialize adjDist : edge.distance
     *
     * 			if visited has no adjacent
     * 				initialize rootToAdjacentDistance : vertexToDistances.get(root).distance + adjDist
     * 				if rootToAdjacentDistance < vertexToDistances.get(adjacent).distance
     * 					update vertexToDistances as
     * 						vertexToDistances.get(adjacent).distance : rootToAdjacentDistance
     * 						vertexToDistances.get(adjacent).prevVertex : root
     *
     * 					minDistance : Math.min(adjDist, minDistance)
     * 					if minDistance equals adjDist then minVertex : adjacent end if
     * 				end if
     *
     * 			end if
     * 		end loop
     * 		add minVertex to queue
     * 	end loop
     *
     *
     *
     *
     *
     */
}
