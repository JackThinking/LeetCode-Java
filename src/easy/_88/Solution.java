package easy._88;

/**
 * Created by Citrix on 2018/7/22.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1;
        int q = n-1;
        int k = m+n-1;
        while(p>=0 && q>=0){
            if (nums1[p]<nums2[q]){
                nums1[k] = nums2[q];
                q--;
                k--;
            }
            else{
                nums1[k] = nums1[p];
                p--;
                k--;
            }
        }
        for (int i = 0; i < q+1; i++) {
            nums1[i] = nums2[i];
        }
    }
}
