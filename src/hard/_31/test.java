package hard._31;

/**
 * Created by Citrix on 2018/10/30.
 */
public class test {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        /*
         * 寻找最小更换转折点
         * */
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i != 0) {
            int j = nums.length - 1;
            /*
            * 这里的判断还是出问题了，思路不够清晰
            * */
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

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
