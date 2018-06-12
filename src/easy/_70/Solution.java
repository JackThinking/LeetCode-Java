package easy._70;

import java.util.ArrayList;

/**
 * Created by Citrix on 2018/6/12.
 */
public class Solution {
    public int climbStairs(int n) {
        /*ArrayList<Integer> arrayList= new ArrayList<Integer>();
        arrayList.add(0, 1);
        arrayList.add(1, 1);
        for (int i = 2; i <= n; i++) {
            arrayList.add(i, arrayList.get(i-1)+arrayList.get(i-2));
        }
        return arrayList.get(n);*/
        int[] sol = new int[n];
        if (n == 0) return 0;
        sol[0] = 1;
        if (n == 1) return 1;
        sol[1] = 2;
        if (n == 2) return 2;
        for (int i = 2; i < n; i++) {
            sol[i] = sol[i-1] + sol[i-2];
        }
        return sol[n-1];



    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
