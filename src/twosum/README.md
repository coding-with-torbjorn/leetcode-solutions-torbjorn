https://leetcode.com/problems/two-sum/description/

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.

You can return the answer in any order

### First Attempt
My initial solution consisted of a brute force approach to the problem. I utilised a nested for loop in order to check if the ``current`` and ``succeeding`` element summed up to ``target``. This solution works but has a time complexity of O(n^2).

```java
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
}
```

### HashMap Online Solution
This solution has a time complexity of O(n), making it faster than my first solution. Instead of using a nested for loop, we iterate over each element in the `nums` array. We utilise a HashMap which consists of elements from the `nums` array as keys and their associated indices as values.

If the HashMap contains an element that is equal to `target - num`, we return an int array containing the current index `i` and the value associated with the element that is equal to `target - num` (other index). Otherwise, we put the current element `num` into the HashMap with its associated index `i` as the value.

```java
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
}
```