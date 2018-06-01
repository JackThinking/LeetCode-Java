---
title: LeetCode-Java
date: 2018-06-01 20:54:57
tags:
    - java
    - leetcode
---
记录一下java刷LeetCode的思路，巩固一下基础。

## Rotate Array（easy）
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

```java
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return;
        }
        k = k % nums.length;
        reverse(nums,0,nums.length - k - 1);
        reverse(nums,nums.length - k, nums.length - 1);
        reverse(nums,0,nums.length-1);
    }
    private  void reverse(int[] nums, int i, int j){
        int temp = 0;
        while (i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
```
这道题之前用python做的时候利用了python数组的简便性，所以很快解决了，但是用java做的时候发现一下子难以下手，思考了之后没啥思路，于是看了一个比较简单易懂的解法实现了一下。
解题思路是for example, nums = [1,2,3,4,5,6,7] and k = 3, first we reverse [1,2,3,4], it becomes[4,3,2,1]; then we reverse[5,6,7], it becomes[7,6,5], finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
即利用基础的置换函数，进行三次置换，最后得到结果。