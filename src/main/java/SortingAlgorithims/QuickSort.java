package SortingAlgorithims;

import java.util.Arrays;

public class QuickSort {

    //if the array has 0 or 1 element it is already sorted
    //otherwise call overloaded quicksort
    public int[] quickSort(int[] arr) {
        if (arr.length <=1) {
            return arr;
        }
        return quickSort(arr, 0, arr.length - 1);
    }

    //this method takes in the whole array, the start index of the current subarray and
    //the end index of the current subarray
    public int[] quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int partition = partition (arr, start, end);
            if (start < partition) {
                quickSort(arr, start, partition);
            }
            if (partition + 1 < end) {
                quickSort(arr, partition + 1, end);
            }
        }
        return arr;
    }

    //this method compares the elements and swaps them
    public int partition(int[] arr, int leftPointer, int rightPointer) {
        System.out.println("Partitioning the current subarray:");
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, leftPointer, rightPointer + 1)));

        //pivot element is the middle of the array
        int pivot = arr[Math.floorDiv((leftPointer + rightPointer), 2)];
        System.out.println("The pivot value is: " + pivot);

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivot) {
                leftPointer++;
                System.out.println("Incrementing left pointer to " + arr[leftPointer]);
            }
            while (arr[rightPointer] > pivot) {
                rightPointer--;
                System.out.println("Decrementing right pointer to " + arr[rightPointer]);
            }
            if (leftPointer < rightPointer) {
                System.out.println("Swapping " + arr[leftPointer] + " and " + arr[rightPointer]);
                Swap.swap(arr, leftPointer, rightPointer);
            }
        }
        return leftPointer;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] unsorted = {39, 15, 24, 35, 76, 19};
        System.out.println("Sorting the array " + Arrays.toString(unsorted));
        qs.quickSort(unsorted);
        System.out.println("After sorting: " + Arrays.toString(unsorted));
    }

}
