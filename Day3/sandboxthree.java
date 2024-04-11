package Day3;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class sandboxthree {
    public static Boolean checkSorted(int[] sortedArray){
        int curValue = sortedArray[0];
        for(int i = 1; i < sortedArray.length; i ++){
            if(curValue < sortedArray[i] || curValue == sortedArray[i]){
                curValue = sortedArray[i];
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] sortedArray = {1,2,3,4,5,6,7,9,10,12,11};
        System.out.println(checkSorted(sortedArray));
        int[] sortedArray1 = {0,0,0,0,0,0,0};
        System.out.println(checkSorted(sortedArray1));
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int[] array1 = {1,1,3,5,76,8,1,2,6,7,8,2,4,1,1,1};
        for(int i = 0; i < array1.length; i ++){
            if(frequencyMap.containsKey(array1[i])){
                frequencyMap.put(array1[i], frequencyMap.get(array1[i]) + 1);
            }else{
                frequencyMap.put(array1[i], 1);
            }
        }

        int mostFrequent = 0;
        int frequency = 0;
        for (Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > frequency) {
                mostFrequent = entry.getKey();
                frequency = entry.getValue();
            }
        }
        
        System.out.println(mostFrequent);
        System.out.println(frequency);

        int totalSum = 0;
        
        int[] array2 = {0,1,2,3,4,5,6,7,8};
        int expectedSum = (array2.length) * ((array2.length + 1) / 2);
        for(int i = 0; i < array2.length; i ++){
            totalSum += array2[i];
        }
        System.out.println(totalSum);
        System.out.println(expectedSum - totalSum);


        String str1 = "ori";
        String str2 = "ori1";
        String str3 = "ori1awfqwefawfawfawfawfawf";
        String str4 = "ori1awfqwefawfawfawfawfawf";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
    }
}
