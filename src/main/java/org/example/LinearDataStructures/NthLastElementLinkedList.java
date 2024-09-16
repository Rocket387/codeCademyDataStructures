package org.example.LinearDataStructures;

public class NthLastElementLinkedList {

    //pointers in parallel
    public static Node nthLastNode(LinkedList list, String n) {

        //2 pointers and a counter
        Node current = null;
        Node tailSeeker = list.head;
        int count = 0;
        Integer.parseInt(n);
        while(tailSeeker != null) {
            tailSeeker = tailSeeker.getNextNode();
            if (count >= n.length()) {
                if (current == null) {
                    current = list.head;
                }
                current = current.getNextNode();
            }
            count++;
        }
        return current;
    }

    public static LinkedList createList() {
        LinkedList list = new LinkedList();
        for (int i = 50; i >= 1; i--) {
            list.addToTail(String.valueOf(i));
        }
        return list;
    }

    public static void main(String [] args) {

        LinkedList ll = createList();
        ll.printList();
        Node n = nthLastNode(ll, String.valueOf(9));
        System.out.println(n.data);
    }
}
