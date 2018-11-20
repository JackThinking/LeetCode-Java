package medium._75;

/**
 * Created by Citrix on 2018/11/20.
 */
public class Review {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p1 = 0, p2 = n - 1, index = 0;
        while (index <= p2) {//这边写错了
            if (nums[index] == 0) {
                nums[index] = nums[p1];//这边也写错了
                nums[p1] = 0;
                p1++;
            } else if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;//这个地方没有考虑到，
            }
            index++;
        }
    }
}
