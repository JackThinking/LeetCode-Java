package medium._334;

/**
 * Created by Citrix on 2018-12-27.
 */
/*
 * 往往这种固定数字的题都会有偷懒的解法，不需要用常规思想去做,这道题就是只需要遍历一次，找最小的和第二小的数，只要有一个数比他们都大就可以了
 * */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
