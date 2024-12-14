package SortingAlgorithims;

import java.util.Arrays;
public class MergeSort {

    //this function recursively splits the input array until each
    //element is in a single-element array
    public int[] sort(int[] arr) {
        //saves length of arr to variable length
        int length = arr.length;

        //if length is less than or equal to 1 return arr
        if (length <= 1) {
            //prints each element of the arr
            System.out.println(Arrays.toString(arr));
            return arr;
        }
        //to find the middle number so the array can be split left and right
        int mid = Math.floorDiv(length, 2);
        int[] leftArray = Arrays.copyOfRange(arr,0,mid); //leftArray exclusive of mid value
        int[] rightArray = Arrays.copyOfRange(arr,mid,length); //rightArray inclusive of mid value


        return merge(sort(leftArray), sort(rightArray));
    }

    //this function merges the leftArray and rightArray
    //takes 2 separate lists as inputs
    //returns sorted list of elements from left and right array combined (merged)
    public int[] merge(int[] left, int[] right) {
        //new empty array the size of left array and right array combined
        int[] merged = new int[left.length + right.length];

        int leftPos = 0;
        int rightPos = 0;
        int currentIndex = 0;

        //while loop continues until length of left array is greater than leftPos
        //and length of right array is greater than right pos
        while (leftPos < left.length && rightPos < right.length) {

            //if statement checks if leftPos is less than rightPo
            //if it is sets currentIndex of merge to leftPos and increment leftPos by 1
            if  (left[leftPos] < right[rightPos]) {
                merged[currentIndex] = left[leftPos];
                leftPos++;
            } else {
                //otherwise set currentIndex of merge to rightPos and increment by 1
                merged[currentIndex] = right[rightPos];
                rightPos++;
            }
            currentIndex++;
        }

        //copies over the remaining elements int he left or right array that are greater than
        //all the elements put into merge so far
        System.arraycopy(left, leftPos, merged, currentIndex, left.length - leftPos);
        System.arraycopy(right, rightPos, merged, currentIndex, right.length - rightPos);
        System.out.println(Arrays.toString(right));
        return merged;
    }

    public static void main(String[] args) {
        MergeSort mergeTest = new MergeSort();
        int[] sortedLeft = {2, 3, 5};
        int[] sortedRight = {4, 7, 90};
        System.out.println(Arrays.toString(mergeTest.merge(sortedLeft, sortedRight)));
    }
}
