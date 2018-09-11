package hard._4;


/**
 * Created by Citrix on 2018/9/10.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = 0;
            int len2 = 0;
            if (nums1 == null && nums2 == null){
                return 0.0;
            }
            else if (nums1 == null){
                len2 = nums2.length;
            }
            else if (nums2 == null){
                len1 = nums1.length;
            }
            else{
                len1 = nums1.length;
                len2 = nums2.length;
            }
            if ((len1+len2)%2 == 0){
                return (double) (findKth(nums1, 0 ,len1 , nums2, 0,len2, (len1+len2)/2)+findKth(nums1, 0 ,len1 , nums2, 0,len2, (len1+len2)/2+1))/2.0;
            }
            else{
                return (double) (findKth(nums1, 0 ,len1 , nums2, 0,len2, (len1+len2)/2+1 ));
            }
        }

        private int findKth(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2, int k)
        {
            /*
             * 统一为len1更小，方便处理
             * */
            if (len1>len2){
                return findKth(nums2, start2, len2, nums1, start1, len1, k);
            }

            /*
             * 循环结束条件
             * */
            if (len1 == 0){
                return nums2[start2+k-1];
            }

            /*
             * 额外的循环结束条件
             * */
        if (k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        /*
        * 最核心的一般处理过程，包含divide
        * */
        int p1 = Math.min(len1, k/2);
        int p2 = k - p1;
        int n1 = nums1[start1+p1-1];
        int n2 = nums2[start2+p2-1];
        if (n1 == n2){
            return n1;
        }
        else if (n1<n2){
            return findKth(nums1, start1+p1 ,len1-p1 , nums2, start2,len2,k-p1);
        }
        else {
            return findKth(nums1, start1 ,len1 , nums2, start2+p2,len2-p2   ,k-p2);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
    }
}
