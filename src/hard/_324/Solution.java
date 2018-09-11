package hard._324;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Citrix on 2018/9/11.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int m = (n+1)>>1;
        int[] copy = Arrays.copyOf(nums,n);
        int mid = kthSmallNumber(nums,m);

        for (int i = 0, j = 0, k = n-1; j <= k; k--) {
            if (copy[j]<mid){
                swap(copy, i++, j++);
            }else if (copy[j]>mid){
                swap(copy, j, k--);
            }
            else {
                j++;
            }
        }

        for (int i = m-1, j = 0; i >= 0 ; i--, j += 2) {
            nums[j] = copy[i];
        }

        for (int i = n-1, j = 1; i >= m ; i--, j += 2) {
            nums[j] = copy[i];
        }
    }

    public int kthSmallNumber(int[] nums, int k){

        /*
        * 这部分随机化快排到时候再理解一下
        * */
        Random random = new Random();

        for (int i = nums.length-1; i >= 0 ; i--) {
            swap(nums, i, random.nextInt(i+1));
        }


        int left = 0, right = nums.length-1;
        k--;
        while (left<right){
            int mid = getMiddle(nums,left,right);
            if (mid<k){
                left = mid + 1;
            }else if (mid>k){
                right = mid - 1;
            }else{
                break;
            }
        }
        return nums[k];
    }

    /*
    * 这部分函数也要在复习一下了
    * */
    public int getMiddle(int[] nums, int left, int right){

        int i = left;
        for (int j = left+1; j <= right; j++) {
            if (nums[j]<nums[left]){
                swap(nums, ++i, j);
            }
        }
        swap(nums, left, i);
        return i;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
