package org.example.LinearDataStructures;

public class FindTheMiddleLinkedList {

    //2 pointers, fast pointer = 2 steps at a time through list
    //slow pointer = 1 step at a time through list
    public static Node findMiddle(LinkedList linkedList) {
        Node fast = linkedList.head;
        Node slow = linkedList.head;

        while (fast != null) {
            fast = fast.getNextNode();
            if (fast != null) {
                fast = fast.getNextNode();
                slow = slow.getNextNode();
            }
        }
        return slow;
    }

    public static LinkedList createList(int length) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= length; i++) {
            list.addToTail(String.valueOf(i));
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList ll2 = createList(7);
        ll2.printList();
        Node n = findMiddle(ll2);
        System.out.println(n.data);
    }
}
