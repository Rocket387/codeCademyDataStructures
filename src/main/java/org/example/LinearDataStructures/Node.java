package org.example.LinearDataStructures;

/**
 * Hello world!
 *
 */
public class Node
{

    public String data;
    public Node next;
    public Node previous;

    public Node(String data) {
        this.data = data;
        this.next = null;

    }

    public void setNextNode(Node node) {

        this.next = node;
    }

    public void setPreviousNode(Node node) {
        this.previous = node;
    }

    public Node getNextNode() {

        return this.next;
    }

    public Node getPreviousNode() {
        return this.previous;
    }

    /*public static void main( String[] args )
    {

        Node firstNode = new Node("a");
        Node secondNode = new Node("b");

        firstNode.setNextNode(secondNode);

        System.out.println(firstNode.data);
        System.out.println(secondNode.data);

        //to loop through the nodes and print each nodes data
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.getNextNode();
        }


    }*/
}
