package medium._300;

/**
 * Created by Citrix on 2018/10/22.
 */
public class test {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int size = 0;
        int[] temp = new int[n];
        for (int num : nums) {
            int left = 0;
            int right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (num > temp[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            temp[left] = num;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
