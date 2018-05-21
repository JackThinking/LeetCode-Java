import java.util.HashMap;

/**
 * Created by Citrix on 2018/5/19.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int[] index = new int[]{0, 1};
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                index[1] = i + 1;
                index[0] = hm.get(target - nums[i]) + 1;
            } else {
                hm.put(nums[i], i);
            }
        }
        return index;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums,target));

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

        }
    }
}

