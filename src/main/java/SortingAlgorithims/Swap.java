package SortingAlgorithims;

import java.util.Arrays;
//this class swaps two elements in an array directly
public class Swap {
    public static void swap(int[] arr, int indexOne, int indexTwo) {
        //To swap pairs of elements, we’ll need to store one of the values at either
        // index in a temporary variable so we can use it later.
        int temp = arr[indexTwo];

        //Change the value at indexTwo of the input array to the value of the element at indexOne
        arr[indexTwo] = arr[indexOne];

        //Set the element at indexOne of the array to the original value of the
        // element at indexTwo by referring to the temp variable
        arr[indexOne] = temp;
    }
}
