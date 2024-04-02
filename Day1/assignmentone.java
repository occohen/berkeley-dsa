package Day1;
/*
Part 1.  
(10 points) Write an example for each of the following. Avoid using examples that were already discussed in class. 
Examples do not necessarily have to be programming related:
O(1) -- 
An algorithm that takes two parameters, n and m, with n representing the number of items sold and m representing the price of each item. 
The algorithm returns an integer n*m, the total revenue generated from these products. Time is independent of size of n and m.
O(log n) -- 
Adjusting the temperature of water. When washing hands, or showering, we adjust the water level somewhere near what we think will be the right temperature. We then adjust it higher or lower depending on if it is too hot or too cold. 
Eventually, we narrow it down through our guesses to whatever the perfect temperature is for us.
O(n) --
Counting items in an array. As the array gets bigger, it takes us longer to go through each index and add it to get the total.
O(n log n) --
Quicksort. We pick an element and divide the array or list into two. Smaller elements than the pivot go on the left, and bigger ones on the right. 
We continue dividing the array, sorting it and then merging the smaller sorted lists as we go. Eventually, we reach a fully sorted array. This is faster than using two loops (O(n^2)).
O(n^2) --
Sorting an array using two loops. 
The outer loop goes through the entire array, and for each iteration, the inner loop checks for the smallest element left in the array and puts it in order. This is slower than quicksort (at scale).
 */


class assignmentone{
    public static void main(String[] args){
         //Part 2
         //set array size
        int arraySize = 5;//(int)((Math.random()*10)+1), if we want to randomize the size of the array
        //init array
        int arr[]= new int[arraySize];
        //populate array
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
            //System.out.println(arr[i]);
        }
        //Begin shuffle
        for (int i = 0; i < arr.length; i++) { 
            int randomIndex = i + (int) (Math.random() * (arr.length - i));
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        for(int i = 0; i < arr.length; i++){
            //System.out.println(arr[i]);
        }
        //Average runtime: O(n). Worst-case: O(n)

        //Part 3. See function implementations below.
        //set up array
        int arr2[]= {0,0,0,0,0,0,0,0,0,1,1,2,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,5,6,7,7,7,7,7,7,7,7};
            //index: 0,1,2,3,4,5,6,7,8,9,10
        //print number of occurences. subtract the leftmost target index from the rightmost target index
        System.out.println(getRightmostIndex(arr2, 4, 0, arr2.length - 1) - getLeftmostIndex(arr2, 4, 0, arr2.length - 1) + 1);
        //Average runtime: O(log n), worstcase runtime: O(log n)
        
        //Part 4. See function implementations below.
        int arr3[] = {0,1,5,7,8,9,10,15};  
        System.out.println(getLargestIndex(arr3, 0, arr3.length - 1));
        //Averge runtime: O(log n), worstcase runtime: O(log n)
    }
    //For part 4: This is a simple binary search: if the low is > than mid, it has to be on the left. Working on this assumption, we narrow the search down.
    public static int getLargestIndex(int[] input, int startIndex, int endIndex){
        int middleIndex = startIndex + (endIndex - startIndex ) / 2;
        if(startIndex == endIndex){
            return startIndex;
        }
        if(input[middleIndex] < input[startIndex]){
            return getLargestIndex(input, startIndex, middleIndex - 1);
        }else {
            return getLargestIndex(input, middleIndex + 1, endIndex);
        }
    }


    //For part 3: binary search: rightmost index
    public static int getRightmostIndex(int[] input, int target, int startIndex, int endIndex){
        //base case, check if target exists within the bounds
        if (startIndex > endIndex) {
            return -1; // Indicates the target is not found in the array.
        }
        //set middle index for binary search
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        //when index with target is found, tweak binary search to check for nontarget values to the right
        if(input[middleIndex] == target){
            if(middleIndex == input.length - 1 || input[middleIndex + 1] != target){
                return middleIndex;
            } else{
                return getRightmostIndex(input, target, middleIndex + 1, endIndex);
            }
        //before target is found, narrow it down
        } else if(input[middleIndex] < target){
            return getRightmostIndex(input, target, middleIndex + 1, endIndex);
        }else if(input[middleIndex] > target){
            return getRightmostIndex(input, target, startIndex, middleIndex - 1);
        }
       //incase of failure
        return -1;
    }
    //repeat the same for the left side of the array
    public static int getLeftmostIndex(int[] input, int target, int startIndex, int endIndex){
        if (startIndex > endIndex) {
            return -1; // Indicates the target is not found in the array.
        }
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if(input[middleIndex] == target){
            if(middleIndex == 0 || input[middleIndex - 1] != target){   
                return middleIndex;
            } else{
                return getLeftmostIndex(input, target, startIndex, middleIndex - 1);
            }
        } else if(input[middleIndex] < target){
            return getLeftmostIndex(input, target, middleIndex + 1, endIndex);
        }else if(input[middleIndex] > target){
            return getLeftmostIndex(input, target, startIndex, middleIndex - 1);
        }
        //incase of failure
        return -1;
    }



}