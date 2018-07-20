package medium._134;

/**
 * Created by Citrix on 2018/7/20.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum_gas = 0;
        int sum_cost = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            sum_gas = sum_gas + gas[i];
            sum_cost = sum_cost + cost[i];
        }
        if (sum_gas != sum_cost){
            return -1;
        }
        int start = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            if (curr+diff>=0){
                curr = curr + diff;
            }
            else{
                curr = 0;
                start = i + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas,cost));
    }
}
