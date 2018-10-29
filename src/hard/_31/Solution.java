package hard._31;


/**
 * Created by Citrix on 2018/10/29.
 */
public class Solution {
    /*
     * 问题难点在于怎么判断大小，以及最接近其大小的排列组合
     * */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        /*
        * 这道题的逻辑和自己的还是接近的，但是他的更加凝练
        * */
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i != 0) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /*
    * reverse的函数学到了
    * */
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
