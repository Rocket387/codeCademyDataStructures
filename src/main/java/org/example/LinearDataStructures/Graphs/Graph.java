package org.example.LinearDataStructures.Graphs;

import java.util.ArrayList;

/*
- Graph is essentially a collection of vertices and edges
- stores all of its vertices, represented by a list of Vertex instances
- Knows if it is directed or undirected
- knows if it is weighted or unweighted
- can add and remove its own vertices
- can add and remove edges between stored vertices
 */
public class Graph {

    //instance variables below include list of vertices
    //and graph properties (weight & direction)
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    //addVertex method simplifies the process of adding a vertex to the graph
    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    //addEdge connects vertices with edges
    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if(!this.isWeighted) {
            weight = null;
        }
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
        vertex1.addEdge(vertex2, weight);
        vertex2.addEdge(vertex1, weight);
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        vertex2.removeEdge(vertex1);
    }

    public Vertex getVertexByValue(String value) {
        for(Vertex v: this.vertices) {
            if (v.getData() == value) {
                return v;
            }
        }
        return null;
    }

    public void print() {
        for(Vertex v: this.vertices) {
            v.print(isWeighted);
        }
    }

    public static void main(String[] args) {
        Graph trainNetwork = new Graph(true, true);
        Vertex atlantaStation = trainNetwork.addVertex("Atlanta");
        Vertex newYorkStation = trainNetwork.addVertex("New York");
        trainNetwork.print();

        trainNetwork.addEdge(atlantaStation, newYorkStation, 800);

        trainNetwork.print();

        trainNetwork.removeEdge(atlantaStation, newYorkStation);

        trainNetwork.print();

    }
}
