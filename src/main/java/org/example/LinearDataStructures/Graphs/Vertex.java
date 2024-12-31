package org.example.LinearDataStructures.Graphs;

import java.util.ArrayList;

/*
- A vertex can store any data
- Maintains a list of connections to other vertices (list of edge instances)
- Can add and remove edges going to another Vertex
 */
public class Vertex {

    private String data;
    private ArrayList<Edge> edges;

    //constructor allows user to pass in data representing the vertex's data
    public Vertex(String inputData) {
        this.data = inputData;

        //edges instance variable (above) used to set up vertex's list of edges
        this.edges = new ArrayList<Edge>();
    }

    public String getData() {
        return this.data;
    }

    //addEdge method connects 2 vertices together by creating an edge
    // and adding it to the vertices' lists of edges
    public void addEdge(Vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void removeEdge(Vertex endVertex) {
        //lambda expression passed as a predicate (accepts a value and determines if true or false)
        //argument on left side of the arrow, boolean condition on the right side
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public void print(boolean showWeight) {
        String message = "";

        if (this.edges.size() == 0) {
            System.out.println(this.data + "-->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().data + " --> ";
            }

            message += this.edges.get(i).getEnd().data;

            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            if (i != this.edges.size() -1) {
                message += ", ";
            }
        }
        System.out.println(message);
    }
    public static void main(String[] args) {

    }
}
