package org.example.LinearDataStructures;

public class DoublyLinkedList {

    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(String data) {
        Node newHead =  new Node(data);
        Node currentHead = this.head;

        //checking to see if there is a current head in the list
        if(currentHead != null) {
            // if list not empty head pointers are reset
            //current heads previous node = newHead
            currentHead.setPreviousNode(newHead);
            //new heads next node = currentHead
            newHead.setNextNode(currentHead);
        }
        //update list head property to newHead
        this.head = newHead;

        //updates tail property to be new head as is both head and tail
        if(this.tail == null) {
            this.tail = newHead;
        }
    }

    public void addToTail(String data) {

        Node newTail = new Node(data);
        Node currentTail = this.tail;

        //check to see if there is a current tail in the list
        //if there is (the list is not empty)
        //reset pointers at the list tail

        if(currentTail != null){

            //set new tails previous node to the current tail
            //update tail property to new tail
            currentTail.setNextNode(newTail);
            newTail.setPreviousNode(currentTail);
        }

        //set current tail's next node to the new tail
        this.tail = newTail;

        //if no current head for list (list was empty)
        //update head property to be new tail
        //as this node will be head and tail
        if (this.head == null) {
            this.head = newTail;
        }
    }

    public String removeHead() {

        Node removedHead = this.head;
        //check for currentHead to list
        //if list is empty return null and end method
        if(removedHead == null) {
            return null;
        }
        //else update lists head to be current heads next node
        this.head = removedHead.getNextNode();

        //if updated head is not null (list had more than one
        //element upon starting
        if(this.head != null) {
            //set heads previous node to null (should be no node
            //before list head)
            this.head.setPreviousNode(null);
        }

        //if removed head was also tail of list (only one
        //element when starting list)
        //call .removeTail() to make necessary changes to the list tail
        if(removedHead == this.tail) {
            this.removeTail();
        }

        //return removed head's data
        return removedHead.data;
    }

    public String removeTail() {
        Node removedTail = this.tail;

        //check if there is a current tail in the list
        //list is empty if there isn't
        //return null method ends
        if(removedTail == null) {
            return null;
        }

        //update lists tail to current tails previous node
        this.tail = removedTail.getPreviousNode();

        //if updated tail not null
        if (this.tail != null) {
            //set tails next node to null
            this.tail.setNextNode(null);
        }

        //if removed tail was also the head of list
        //(only one element in list) call .removeHead()
        if(removedTail == this.head) {
            this.removeHead();
        }

        return removedTail.data;
    }

    public Node removeByData(String data) {
        Node nodeToRemove = null;
        Node currentNode = this.head;

        //iterate through the list to find the matching node
        while(currentNode != null) {
            if(currentNode.data == data) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNextNode();
        }

        //if no matching element return null
        if(nodeToRemove == null) {
            return null;
        }

        //if there is a matching node
        //check to see if it is the head or tail
        //if so call removeHead or removeTail method
        if(nodeToRemove == this.head) {
            removeHead();
        } else if(nodeToRemove == this.tail) {
            removeTail();
        } else {
            //if not node is somewhere in the middle
            //remove it by resetting pointer of previous
            //and next nodes
            Node nextNode = nodeToRemove.getNextNode();
            Node previousNode = nodeToRemove.getPreviousNode();

            nextNode.setPreviousNode(previousNode);
            previousNode.setNextNode(nextNode);
        }

        //return nodes data
        return nodeToRemove;

    }

    public String printList() {
        Node currentNode = this.head;
        String output = "<head> ";
        while(currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        DoublyLinkedList underGroundStations = new DoublyLinkedList();

        underGroundStations.addToHead("Victoria");
        underGroundStations.addToHead("Jubilee");
        underGroundStations.addToHead("Elizabeth");
        underGroundStations.addToTail("Bakerloo");
        underGroundStations.addToTail("Metropolitan");
        underGroundStations.addToTail("Circle");

        underGroundStations.printList();

        underGroundStations.removeTail();
        underGroundStations.removeHead();

        underGroundStations.printList();

        underGroundStations.removeByData("Bakerloo");
        underGroundStations.printList();
        underGroundStations.removeByData("District");
        underGroundStations.printList();

    }
}
