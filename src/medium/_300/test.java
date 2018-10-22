package medium._300;

/**
 * Created by Citrix on 2018/10/22.
 */
public class test {
    public int lengthOfLIS(int[] nums) {
        int size = 0;
        int n = nums.length;
        int[] list = new int[n];
        for (int num : nums) {
            int i = 0;
            int j = size;//为什么不是size-1
            /*
            * 居然是不等于
            * */
            while (i != j) {
                int mid = i + (j - i) / 2;
                if (num > list[mid]) {
                    i = mid + 1;
                } else
                    j = mid;//这边也是
            }
            list[i] = num;
            /*
            * 新来的数比之前的都大，所以size扩大
            * */
            if (size == i) {
                size++;
            }
        }
        return size;
    }
}
