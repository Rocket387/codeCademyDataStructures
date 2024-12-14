package SortingAlgorithims;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int input[]) {
        //swapping boolean variable to determine whether the loop keeps going or stops
        boolean swapping = true; // true runs the loop at least once
        //true, our input array might still be unsorted and need additional swaps of elements.
        // This triggers the loop to go another iteration.
        //false, we assume the input array does not need any more swapping to sort it.

        //while loop that runs while swapping is necessary (swapping = true)
        while (swapping) {

            //stops the while loop running forever
            swapping = false;

            //for loop visits every element in the input array
            //stops at the second to last element (input.length - 1) to stay within the bounds of the array
            for (int i = 0; i < input.length - 1; i++) {

                //if condition checks if the element at the current index is greater than the element one index after it
                if (input[i] > input[i + 1]) {
                    System.out.println(String.format("Swapping pair %d, %d", input[i],
                            input[i+1]));
                    // if true swap the two elements using Swap class
                    Swap.swap(input, i, i+1);

                    //If we make a swap, we want the loop to go again to check if we need to make more swaps
                    // to continue “bubbling up” the unsorted elements.
                    // so swapping is set to true
                    swapping = true;
                    System.out.println(Arrays.toString(input));
                }
            }
        }
        //method returns the sorted input array
        return input;
    }

    public static void main(String[] args) {
        int[] example = {13, 22, 50, 15, 20, 33, 33};
        BubbleSort b = new BubbleSort();
        b.bubbleSort(example);

        System.out.println("\n");

        int[] count_backwards = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Starting BubbleSort on reverse sorted: "
                + Arrays.toString(count_backwards));
        // Call bubble sort on reverse sorted
        bubbleSort(count_backwards);

        System.out.println("After Bubble Sort: "
                + Arrays.toString(count_backwards));

        System.out.println("\n");

        int[] count_forwards = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Starting BubbleSort on sorted: "
                + Arrays.toString(count_forwards));
        // Call bubble sort on sorted
        bubbleSort(count_forwards);
        System.out.println("After BubbleSort: " + Arrays.toString(count_forwards));
    }
}
