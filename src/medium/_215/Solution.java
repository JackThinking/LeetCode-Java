package medium._215;

/**
 * Created by Citrix on 2018/7/26.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSort(nums,0,n-1,n-k);
        return nums[n-k];
    }
    private void quickSort(int[] nums, int start, int end, int target){
        if (start>=end){
            return;
        }
        int mid = start  + (end - start)/2;
        int pivot = choosePivot(nums[mid], nums[start], nums[end]);
        int i = start;
        int j = end;
        while(i<=j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (nums[i] != nums[j]) {
                    swap(nums, i, j);
                }
                i++;
                j--;
            }
        }
        if(target <= i - 1){
            quickSort(nums, start, i - 1, target);
        }
        else{
            quickSort(nums, i, end, target);
        }
    }

    private int choosePivot(int a, int b, int c) {
        if(a > b){
            if(c > a){
                return a;
            }
            else if(c > b){
                return c;
            }
            else{
                return b;
            }
        }
        else{
            if(c > b){
                return b;
            }
            else if(c > a){
                return c;
            }
            else{
                return a;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
