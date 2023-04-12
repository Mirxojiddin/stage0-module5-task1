package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seasons = new String[4];
        seasons[0] = "winter";
        seasons[0] = "spring";
        seasons[0] = "summer";
        seasons[0] = "autumn";

        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] new_array = new int[length];
        for (int i=0; i<length; i++)
            new_array[i] = i+1;

        return new_array;
        

    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int summ = 0;
        for (int i=0; i<arr.length; i++)
            summ+=arr[i];
        return summ;

    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i=0; i<arr.length; i++)
            if (arr[i]==number)
                return i;
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reverse = new String[arr.length];
        for (int j=0,i=arr.length-1; i>=0; i++)
            reverse[j++]=arr[i];
        return reverse; 
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int[] result = new int[arr.length];
        for (int j=0,i=0; i<arr.length; i++)
            if (arr[i]>0)
                result[j++]=arr[i];
        return result;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    private static class MergeSort {
        private static int[] array;

        public static void mergeSort(int[] arr) {
            array = arr;
            int len = array.length;
            int[] workspace = new int[len];
            recursiveMergeSort(workspace, 0, len - 1);
        }

        private static void recursiveMergeSort(int[] workSpace, int lowerBound,
                                        int upperBound) {
            if (lowerBound == upperBound) {
                return;
            } else {
                int mid = (lowerBound + upperBound) / 2;
                recursiveMergeSort(workSpace, lowerBound, mid);
                recursiveMergeSort(workSpace, mid + 1, upperBound);
                merge(workSpace, lowerBound, mid + 1, upperBound);
            }
        }

        private static void merge(int[] workspace, int lowPointer,
                           int highPointer, int upperBound) {
            int i = 0;
            int lowerBound = lowPointer;
            int mid = highPointer - 1;
            int numberOfItems = upperBound - lowerBound + 1;

            while (lowPointer <= mid && highPointer <= upperBound) {
                if (array[lowPointer] < array[highPointer]) {
                    workspace[i++] = array[lowPointer++];
                } else {
                    workspace[i++] = array[highPointer++];
                }
            }

            while (lowPointer <= mid)
                workspace[i++] = array[lowPointer++];

            while (highPointer <= upperBound)
                workspace[i++] = array[highPointer++];

            for (i = 0; i < numberOfItems; i++)
                array[lowerBound + i] = workspace[i];
        }
    }

    // public int[][] sortRaggedArray(int[][] arr) {
    //     int arrat_len = arr.length;
    //     for (int i=0; i<arrat_len; i++)
    //         for (int j=0; j<arr[i].length; j++){
    //             int index = j;
    //             for (int k = j+1; k<arr[i].length; k++)
    //                 if (arr[i][k]<arr[i][index])
    //                     index = k;
    //             int son = arr[i][j];
    //             arr[i][j]=arr[i][index];
    //             arr[i][index]=son;   
    //         }
    //         return arr;

    // }

    public int[][] sortRaggedArray(int arr[][]) {
        int arrat_len = arr.length;
        for (int i=0; i<arrat_len; i++)
            MergeSort.mergeSort(arr[i]); 
        
        for (int j = 0; j<arrat_len; j++){
                int index = j;
                    for (int k = j+1; k<arrat_len; k++)
                        if (arr[k].length<arr[index].length){
                            index = k;
                        }
                    int son[] = arr[j];
                    arr[j]=arr[index];
                    arr[index]=son;   
        }
        for (int j = 0; j<arrat_len; j++){
            for (int k =0; k<arr[j].length; k++)
                System.out.print(arr[j][k]+" ");
            System.out.println();
        }
            return arr;

    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            { 12, 11, 13, 5, 6, 9},     // the first row 
            { 5, 2, 6, 7, 12, 1 },
            { 5, 2, 6, 7, 12 },
            { 5, 2, 6, 7, 12,5,6,8,7 }
        };
        new ArrayTasks().sortRaggedArray(arr);
    }

}
