package easy._278;

/**
 * Created by Citrix on 2018/7/21.
 */
public class Solution {
    public int firstBadVersion(int n) {
        int[] nums= {0,1,1};
        int left = 1;
        int right = n;
        while(left<=right){
            //int mid = left + (right-left)/2;
            int mid = (left + right)/2;
            if (nums[mid-1] == 1){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(3));
    }

}
