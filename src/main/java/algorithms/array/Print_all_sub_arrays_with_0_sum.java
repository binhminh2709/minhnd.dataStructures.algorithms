package algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Print_all_sub_arrays_with_0_sum {

  /*
  For example,
    Input:  { 4, 2, -3, -1, 0, 4 }
    Sub-arrays with 0 sum are

    { -3, -1, 0, 4 }
    { 0 }


    Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
    Sub-arrays with 0 sum are

    { 3, 4, -7 }
    { 4, -7, 3 }
    { -7, 3, 1, 3 }
    { 3, 1, -4 }
    { 3, 1, 3, 1, -4, -2, -2 }
    { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
    Related Post: Check if subarray with 0 sum is exists or not
  * */

  public static void main(String[] args) {
    /**
     *Approach 1: Naive solution
     * Naive solution would be to consider all sub-arrays and find its sum.
     * If sub-array sum is equal to 0, we print it.
     * The time complexity of naive solution is O(n^3) as there are n^2 sub-arrays and it takes O(n) time to find sum of its elements.
     * The method can be optimized to run in O(n^2) time by calculating sub-array sum in constant time.
     *
     */
    int[] A = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};

    PrintallSubarraysOne.printallSubarrays(A);

    /**
     * Approach 2: Using multimap to print all subarrays
     * We can use MultiMap to print all sub-arrays with 0 sum present in the given array.
     * The idea is to create an empty multimap to store ending index of all sub-arrays having given sum.
     * We traverse the given array, and maintain sum of elements seen so far.
     * If sum is seen before, there exists at-least one sub-array with 0 sum which ends at current index and we print all such sub-arrays.
     * */
    PrintallSubarraysTwo.printallSubarrays(A);

    //Exercise: Extend the solution for non-zero sum of sub-array (http://www.techiedelight.com/find-subarrays-given-sum-array/)
  }

  static class PrintallSubarraysOne {

    // Function to print all sub-arrays with 0 sum present
    // in the given array
    public static void printallSubarrays(int[] A) {
      // consider all sub-arrays starting from i
      for (int i = 0; i < A.length; i++) {
        int sum = 0;

        // consider all sub-arrays ending at j
        for (int j = i; j < A.length; j++) {
          // sum of elements so far
          sum += A[j];

          // if sum is seen before, we have found a subarray with 0 sum
          if (sum == 0) {
            System.out.println("Subarray [" + i + ".." + j + "]");
          }
        }
      }
    }
  }

  static class PrintallSubarraysTwo {

    // Utility function to insert <key, value> into the Multimap
    private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
      // if the key is seen for the first time, initialize the list
      if (!hashMap.containsKey(key)) {
        hashMap.put(key, new ArrayList<>());
      }

      hashMap.get(key).add(value);
    }

    // Function to print all sub-arrays with 0 sum present in the given array
    public static void printallSubarrays(int[] A) {
      // create an empty Multi-map to store ending index of all sub-arrays having same sum
      Map<Integer, List<Integer>> hashMap = new HashMap<>();

      // insert (0, -1) pair into the map to handle the case when
      // sub-array with 0 sum starts from index 0
      insert(hashMap, 0, -1);

      int sum = 0;

      // traverse the given array
      for (int i = 0; i < A.length; i++) {
        // sum of elements so far
        sum += A[i];

        // if sum is seen before, there exists at-least one
        // sub-array with 0 sum
        if (hashMap.containsKey(sum)) {
          List<Integer> list = hashMap.get(sum);

          // find all sub-arrays with same sum
          for (Integer value : list) {
            System.out.println("Subarray [" + (value + 1) + ".." + i + "]");
          }
        }

        // insert (sum so far, current index) pair into the Multi-map
        insert(hashMap, sum, i);
      }
    }

  }


}
