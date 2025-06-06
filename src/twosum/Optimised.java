package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Optimised {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairIndex = new HashMap<>(); // key=element, value=index

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // current element

            // if the HashMap (pairIndex) contains a key that when summed with the current element (num) equals target,
            // return the current index and index of the number in the HashMap
            if (pairIndex.containsKey(target - num)) {
                return new int[] { i, pairIndex.get(target - num) };
            }

            // otherwise, add current element and its index to the HashMap
            pairIndex.put(num, i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        Optimised optimised = new Optimised();
        System.out.println(Arrays.toString(optimised.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}