package twosum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute force solution:
        // E.g. nums = [2,7,11,15], target = 9
        int[] twoSum = new int[2];

        // For each element in nums, sum the current element with the succeeding element.
        for (int current = 0; current < nums.length - 1; current++) {
            for (int succeeding = current + 1; succeeding < nums.length; succeeding++) {
                // If this sum is equal to target, add the indices of the two elements to the twoSum array.
                if (nums[current] + nums[succeeding] == target) {
                    twoSum[0] = current;
                    twoSum[1] = succeeding;
                }
            }
        }

        return twoSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}