package easy._88;

/**
 * Created by Citrix on 2018/11/22.
 */
public class Review {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int k = m + n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[k] = nums1[p];
                k--;
                p--;
            } else {
                nums1[k] = nums2[q];
                k--;
                q--;
            }
        }
        /*
        * 由于q是在不断变化的，若是q走完了就是-1，否则剩下的数其实也是p还没有走的数
        * */
        for (int i = 0; i < q + 1; i++) {
            nums1[i] = nums2[i];
        }
    }
}
