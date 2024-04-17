package Day3;

/*
Problem 1:
Describe the worst case data and the best case data for each of the following sorting algorithms.
Also, include the big O notation for each case.
Bubble Sort 
Worst Case - sorted in opposite order. For example, if we wanted ascending order, it would be [5,4,3,2,1] and would be O(n^2) time complexity
Best Case - sorted in the order we want. For example, if we wanted ascending order, it would be [1,2,3,4,5] and would be O(n) time complexity

Selection Sort
Worst Case - There is no worst case. Every single way it could be sorted will result in O(n^2) time complexity.
Best Case - There is no best case. Every single way it could be sorted will result in O(n^2) time complexity.

Insertion Sort
Worst Case - sorted in opposite order. For example, if we wanted ascending order, it would be [5,4,3,2,1] and would be O(n^2) time complexity
Best Case - sorted in the order we want. For example, if we wanted ascending order, it would be [1,2,3,4,5] and would be O(n) time complexity

Merge Sort
Worst Case - There is no worst case. Every single way it could be sorted will result in O(n logn) time complexity.
Best Case - There is no best case. Every single way it could be sorted will result in O(n logn) time complexity.

Quicksort
Worst Case - When the pivots chosen are the largest (or smallest) elements in any given subarray. If we wanted an ascending order, a descending-order sorted array would achieve this. Each time a pivot is chosen, all of the values will be to either the left or right of it. This leads to O(n^2) complexity as each search needs to iterate through the entire list.
Best Case - Choosing good pivots. If we had an array [0,5,4,3,2,6,1] and we chose 3 or 4 as our pivot, there will be nearly the same amount of values of either side of the pivot. When there is good balance, the time complexity gets closer to the average of O(n logn)

 */
import java.util.HashMap;
import java.util.ArrayList;
public class assignmentthree {
    public static void main(String[] args) {
        //problem 2
        int[] arr1 = {1,5,7,9,4,2};
        insertionSort(arr1);

        //problem 3
        int[] missingArray = {0,1,3,5,6,6,6,7,7,1};
        //should have all the numbers 0-9 (10 numbers)
        //missing 2,4,8,9
        findMissing(missingArray);


        //problem 4
        String str1 = "abebadbbc";
        //should return c
        //ystem.out.println(firstNonRepeatingChar(str1));

        //problem 5
        int[] inputArray = {14,9,5,7,9,2};
        int target = 23;
        //System.out.println(longestSubarrayWithSum(inputArray, target));

    }
    public static int[] insertionSort(int[] arr){
        //[1,5,7,9,4,2]
        //[1,5,7,9,9,2] cur = 4
        //[1,4,5,7,9,2] cur = 4
        //[1,4,5,7,9,2] cur = 2
        //[1,4,5,7,9,9] cur = 2
        //[1,4,5,7,7,9] cur = 2
        //[1,4,5,5,7,9] cur = 2
        //[1,4,4,5,7,9] cur = 2
        //[1,1,4,5,7,9] cur = 2
        //[1,2,4,5,7,8] cur = 2
    for (int i = 1; i < arr.length; i++) {
        int current = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > current) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = current;
    }
    for(int i = 0; i < arr.length; i ++){
        //System.out.print(arr[i] + ",");
    }
    return arr;
    }
    public static ArrayList<Integer> findMissing(int[] missingArray){
        //create hashmap, loop through missing array, add values yes/no for existing ones
        //loop through all numbers. if number missing, add it to list.
        ArrayList<Integer> missingValues = new ArrayList<Integer>();
        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
        for(int i = 0; i < missingArray.length; i++){
            hashMap.put(missingArray[i], true);
        }
        for(int i = 0; i < missingArray.length; i++){
            if(hashMap.get(i) == null){
                missingValues.add(i);
            }
        }
        //System.out.println(hashMap);
        for(int i = 0; i < missingValues.size(); i++){
            //System.out.println(missingValues.get(i));
        }

    return missingValues;
    }
    
    public static String firstNonRepeatingChar(String str){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(int i = 0; i < str.length(); i++){
            if(hashMap.get(str.substring(i,i+1)) != null){
                hashMap.put(str.substring(i,i+1), hashMap.get(str.substring(i,i+1)) + 1);
            } else{
                hashMap.put(str.substring(i,i+1), 1);
            }
        }
        for(int i = 0; i < str.length(); i++){
            if(hashMap.get(str.substring(i,i+1)) == 1){
                return str.substring(i,i+1);
            }
        }
        return "None";
    }

    public static int longestSubarrayWithSum(int[] arr, int target) {
        //hashmap; sum, i value
             HashMap<Integer, Integer> map = new HashMap<>();
             //cursum, maxlength found so far
             int curSum = 0;
             int maxLength = 0;
             for (int i = 0; i < arr.length; i++) {
                  curSum += arr[i];
                //length is one bigger
                  if (curSum == target){
                      maxLength = i + 1;
                  }
                  //add keys for each cursum that doesn't exist
                  if (!map.containsKey(curSum)) {
                      map.put(curSum, i);
                  }
                //if it already exists (0 for the target) find the bigger max length and set that
                  if (map.containsKey(curSum - target)) {
                      if (maxLength < (i - map.get(curSum - target))){
                          maxLength = i - map.get(curSum - target);
                      }
                  }
             }
             return maxLength;    
    }

}
