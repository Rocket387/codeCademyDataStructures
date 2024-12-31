package org.example.LinearDataStructures.Graphs;

public class TrainNetwork {
    public static void main(String[] args) {

        Graph trainNetwork = new Graph(true, true);
        Vertex v1 = trainNetwork.addVertex("Los Angeles");
        Vertex v2 = trainNetwork.addVertex("San Francisco");
        Vertex v3 = trainNetwork.addVertex("New York");
        Vertex v4 = trainNetwork.addVertex("Atlanta");
        Vertex v5 = trainNetwork.addVertex("Denver");
        Vertex v6 = trainNetwork.addVertex("Calgary");

        trainNetwork.addEdge(v1, v2, 400);
        trainNetwork.addEdge(v2, v1, 400);
        trainNetwork.addEdge(v3, v5, 1800);
        trainNetwork.addEdge(v5, v3, 1800);
        trainNetwork.addEdge(v6, v5, 1000);
        trainNetwork.addEdge(v5, v6, 1000);
        trainNetwork.addEdge(v1, v4, 2100);
        trainNetwork.addEdge(v4, v1, 2100);

        trainNetwork.removeEdge(v3, v5);
        trainNetwork.removeEdge(v5, v6);
        trainNetwork.removeEdge(v6, v5);
        trainNetwork.removeVertex(v6);

        trainNetwork.print();

    }
}
