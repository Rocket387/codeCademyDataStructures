package org.example.LinearDataStructures;

public class LinkedList {

    //Node variable for linkedList head
    public Node head;

    //LinkedList constructor
    public LinkedList() {
        //setting lists head to null
        this.head = null;
    }

    //method adds String to head of list
    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            //sets newHeads next node to the past head
            //to maintain list
            this.head.setNextNode(currentHead);
        }
    }

    //method adds String to the tail of list
    public void addToTail(String data) {
        //Node named tail set equal to the lists head
        Node tail = this.head;

        //if statement checks tail has no value
        //if null set lists head equal to a new Node
        //that takes data as an argument
        if (tail == null) {
            this.head = new Node(data);
        } else {
            //while loop runs while tail has a next node
            //setting tail to the next Node
            while(tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            //sets tails next node to a new Node
            //with data as argument
            tail.setNextNode(new Node(data));
        }
    }

    //method removes the head string of the list
    public String removeHead() {

        //node equal to lists head
        Node removedHead = this.head;

        //checks Node has no value
        if (removedHead == null) {
            return null;
        }
        //if not null lists head gets next node
        //which is equal to null
        this.head = removedHead.getNextNode();
        return removedHead.data;
    }

    //method prints the linked list in order
    public String printList() {
        //String identifies which end of the list the head is at
        String output = "<head> ";

        //Node equal to lists head
        Node currentNode = this.head;

        //loops through list printing node data
        while (currentNode != null) {
            output += currentNode.data + " ";
            
            //set currentNode to NextNode
            currentNode = currentNode.getNextNode();
        }
        output += ("<tail>");
        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        LinkedList seasons = new LinkedList();
        seasons.addToHead("summer");
        seasons.addToHead("spring");
        seasons.addToTail("fall");
        seasons.addToTail("winter");
        seasons.printList();

        seasons.removeHead();
        seasons.printList();

        LinkedList months = new LinkedList();

        months.addToHead("June");
        months.addToHead("May");
        months.addToHead("April");
        months.addToHead("March");
        months.addToHead("February");
        months.addToHead("January");

        months.addToTail("July");
        months.addToTail("August");
        months.addToTail("September");
        months.addToTail("October");
        months.addToTail("November");
        months.addToTail("December");

        months.printList();
        months.removeHead();

        months.printList();

        months.removeHead();
        months.printList();
    }

}
