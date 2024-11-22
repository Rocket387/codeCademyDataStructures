package org.example.LinearDataStructures.NonLinearDataStructures.Trees.Heaps;

import java.util.ArrayList;
import java.util.Random;

/*
two components of the heap condition that a MinHeap MUST satisfy:

The element at
Preview: Docs Improves the speed of data retrieval in the database.
index
 1 is the minimum value in the entire ArrayList.
Every child element in the ArrayList must be larger than its parent.
 */
public class MinHeap {

    public ArrayList<Integer> heap;
    public int size;

    public MinHeap() {
        this.heap = new ArrayList<Integer>();
        this.heap.add(null);
        this.size = 0;
    }

    //adding an element
    public void add(int value) {
        this.heap.add(value);
        this.size++;
        System.out.println("Adding " + value);
        System.out.println(this.heap);
        this.bubbleUp();
    }

    //popMin() to remove the minimum value
    //can only remove an element with no children
    //so min needs to be swapped to the last element
    public int popMin() {
        //if statement checks if heap is empty and throws error if is
        if (this.size == 0) {
            throw new Error("Heap is empty");
        }
        System.out.println("Swap min element " + this.heap.get(1) + " and last element " + this.heap.get(this.size));
        //swaps min element with last element ready for removing
        this.swap(1, this.size);

        //removes element using ArrayList .remove()
        int min = this.heap.remove(this.size);
        System.out.println("Removed from the heap: " + min);

        System.out.println(this.heap);
        //decreases heap size to reflect the min element removal
        this.size--;
        return min;

    }

    //bubbleUp() ensures the heap always maintains smallest element at the root
    private void bubbleUp() {
        // Instantiate current storing last inndex of this.heap (always the locaiton of the added element)
        int current = this.size;
        int swapCount = 0;
        // 2 conditions 1. any index greater than 1, 2. value at current is less than its parent value
        while (current > 1 && this.heap.get(current) < this.heap.get(this.getParent(current))) {
            //swap elements to restore the heap
            System.out.println("Swap index " + current + " with index " + this.getParent(current));
            System.out.println(this.heap);
            //call to swap method
            this.swap(current, this.getParent(current));
            current = this.getParent(current);
            if (this.size == 10000) {
                System.out.println("A heap of " + this.size + " elements was restored with only " + swapCount + " swaps!");
            }
        }
    }

    //heapify method to shift elements down the tree after a swap and removal
    private void heapify() {
        int current = 1;
        int leftChild = this.getLeft(current);
        int rightChild = this.getRight(current);
        int swapCount = 0;
        while (this.canSwap(current, leftChild, rightChild)) {
            if (this.exists(leftChild) && this.exists(rightChild)) {
                if (this.heap.get(leftChild) < this.heap.get(rightChild)) {
                    this.swap(current, leftChild);
                    current = leftChild;
                    swapCount++;
                } else {
                    this.swap(current, rightChild);
                    current = rightChild;
                    swapCount++;
                }

            } else {
                this.swap(current, leftChild);
                current = leftChild;
                swapCount++;
            }
            leftChild = this.getLeft(current);
            rightChild = this.getRight(current);
        }
        if (this.size == 9999) {
            System.out.println("A heap of " + this.size + " elements was restored with only " + swapCount + " swaps!");
        }
    }

    private void swap(int a, int b) {
        int temp = this.heap.get(b);
        this.heap.set(b, this.heap.get(a));
        this.heap.set(a, temp);
    }

    private boolean exists(int index) {
        return index <= this.size;
    }

    private boolean canSwap(int current, int leftChild, int rightChild) {
        return (this.exists(leftChild) && (this.heap.get(current) > this.heap.get(leftChild)))
                || (this.exists(rightChild) && (this.heap.get(current) > this.heap.get(rightChild)));
    }

    //child and parent elements are determined by their relative indices within heap.
    public int getParent(int current) {
        return (int) Math.floor(current / 2);
        //parent = index /2
    }

    public int getLeft(int current) {
        return current * 2;
        //left = index * 2
    }

    public int getRight(int current) {
        return (current * 2) + 1;
        //right = (index * 2) + 1
    }

    public static void main(String[]args) {
        MinHeap minHeap = new MinHeap();
        System.out.println(minHeap.heap);

        minHeap.add(10);
        minHeap.add(13);
        minHeap.add(21);
        minHeap.add(61);
        minHeap.add(22);
        minHeap.add(23);
        minHeap.add(99);

        //display parent, left and right indices of currentIndex
        int currentIndex = 3;
        System.out.println("--------");
        System.out.println("Looking at Index " + currentIndex);
        System.out.println("Parent index " + minHeap.getParent(currentIndex));
        System.out.println("Left child index " + minHeap.getLeft(currentIndex));
        System.out.println("Right child index " + minHeap.getRight(currentIndex));

        //display the parent, left and right values of currentValue
        int currentValue = minHeap.heap.get(currentIndex);
        System.out.println("The value at index 3 is " + currentValue);
        System.out.println("Parent value: " + minHeap.heap.get(minHeap.getParent(currentIndex)));
        System.out.println("Left value: " + minHeap.heap.get(minHeap.getLeft(currentIndex)));
        System.out.println("Right value: " + minHeap.heap.get(minHeap.getRight(currentIndex)));

        System.out.println("\n");

        MinHeap minHeap4 = new MinHeap();

        //populate minHeap4 with 6 random numbers
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            System.out.println("-----------");
            int int_random = r.nextInt(40);
            minHeap4.add(int_random);
        }

        // Display the heap after bubbling up
        System.out.println("-------------");
        System.out.println("BUBBLED UP: " + minHeap4.heap);

        //remove the minimum value
        minHeap.popMin();

        System.out.println("\n");

        MinHeap minHeap7 = new MinHeap();

        // Populate minHeap with descending #s from 10001 to 1
        System.out.println("Adding 10000 individual elements...");
        for (int i = 10000; i >= 1; i--) {
            minHeap7.add(i);
        }
        // Remove minimum value from minHeap
        System.out.println("Removing the minimum value...");
        System.out.println("Minimum value: " + minHeap7.popMin());
    }

    }

}
