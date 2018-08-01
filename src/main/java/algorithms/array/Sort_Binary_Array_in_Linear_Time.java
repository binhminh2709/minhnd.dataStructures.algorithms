package algorithms.array;

import java.util.Arrays;

public class Sort_Binary_Array_in_Linear_Time {

  /**
   * Given an binary array, sort it in linear time and constant space. Output should print contain all zeroes followed by all ones. For example, Input: { 1, 0, 1, 0, 1, 0, 0, 1 } Output:{ 0, 0, 0, 0,
   * 1, 1, 1, 1 }
   */
  public static void main(String[] args) {
    /**
     * Simple solution would be to count number of 0’s present in the array (say k) and fill first k indices in the array by 0 and all remaining indices by 1.
     * Alternatively, we can also count number of 1’s present in the array (say k) and fill last k indices in the array by 1 and all remaining indices by 0.
     * */
    int A[] = {0, 0, 1, 0, 1, 1, 0, 1, 0, 0};

    SortBinaryArrayOne.sort(A);
    // print the rearranged array
    System.out.println(Arrays.toString(A));
    //The time complexity of above solution is O(n) and auxiliary space used by the program is O(1).

    /**
     * Instead of counting number of zeroes, if the current element is 0, we can place 0 at next available position in the array.
     * After all elements in the array are processed, we fill all remaining indices by 1.
     * */
    SortBinaryArrayTwo.sort(A);
    System.out.println(Arrays.toString(A));
  }

  static class SortBinaryArrayOne {

    // Function to sort binary array in linear time
    public static void sort(int[] A) {
      // count number of 0's
      int zeros = 0;
      for (int i = 0; i < A.length; i++) {
        if (A[i] == 0) {
          zeros++;
        }
      }

      // put 0's in the beginning
      int k = 0;
      while (zeros-- != 0) {
        A[k++] = 0;
      }

      // fill all remaining elements by 1
      while (k < A.length) {
        A[k++] = 1;
      }
    }
  }

  static class SortBinaryArrayTwo {

    // Function to sort binary array in linear time
    public static void sort(int[] A) {
      // k stores index of next available position
      int k = 0;

      // do for each element
      for (int i = 0; i < A.length; i++) {
        // if current element is zero, put 0 at next free
        // position in the array
        if (A[i] == 0) {
          A[k++] = 0;
        }
      }

      // fill all remaining indices by 1
      for (int i = k; i < A.length; i++) {
        A[k++] = 1;
      }
    }
  }
}
