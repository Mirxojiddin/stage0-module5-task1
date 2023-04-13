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
        seasons[1] = "spring";
        seasons[2] = "summer";
        seasons[3] = "autumn";

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
        for (int j=0,i=arr.length-1; i>=0; i--)
            reverse[j++]=arr[i];
        for (int i=0; i<arr.length; i++)
            System.out.print(reverse[i]+" ");
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
        int j=0;
        for (int i=0; i<arr.length; i++)
            if (arr[i]>0)
                j++;
        int[] result = new int[j];    
        for (int k=0, i=0; i<arr.length; i++)
            if (arr[i]>0)
                result[k++]=arr[i];
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

    public int[][] sortRaggedArray(int[][] arr) { 
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr[i].length; j++) { 
                for (int k = j + 1; k < arr[i].length; k++) { 
                    if (arr[i][j] > arr[i][k]) { 
                        int temp = arr[i][k]; 
                        arr[i][k] = arr[i][j]; 
                        arr[i][j] = temp; 
                    } 
                } 
            } 
        } 
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr.length - 1; j++) { 
                if (arr[j].length > arr[j + 1].length) { 
                    int[] temp_arr = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp_arr; 
                } 
            } 
        } 
        return arr; 
    }



/*
 * 
 *  * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
 * 
 */

    public static void main(String[] args) {
        int[][] arr = {
            {-13, -908,2312,-723},
            {-13, -905,2312,-723}, 
             {7}
        };
        
        
        new ArrayTasks().sortRaggedArray(arr);
    }

}
