package medium._241;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/9/9.
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        List<String> operaters = new ArrayList<>();
        split(input,nums,operaters);//以后有想法就先把函数写出来再说
        return calculate(nums, operaters, 0, nums.size()-1);
    }

    private void split(String input, List<Integer> nums, List<String> operaters){
        StringBuilder sb = new StringBuilder();//不需要预先设置长度
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);//charAt充当遍历器
            if (character == '+' || character == '-' || character == '*'){
                nums.add(Integer.valueOf(sb.toString()));//是错位的加法
                sb = new StringBuilder();
                operaters.add(character+"");//只是为了char 2 string,一定要是双引号
            }
            else {
                sb.append(character);//这么感觉有点蠢，之后再看看
            }
        }
        nums.add(Integer.valueOf(sb.toString()));
    }

    private List<Integer> calculate(List<Integer> nums, List<String> operaters, int start, int end){
        List<Integer> res = new ArrayList<>();//这个是要返回的结果呀
        /*
        * 写结束条件,也可以理解为dp中的备忘录
        * */
        if (start == end){
            res.add(nums.get(start));
            return res;
        }
        /*
        * 一般处理情况
        * */
        for (int i = start; i < end; i++) {
            List<Integer> left = calculate(nums, operaters, start, i);
            List<Integer> right = calculate(nums, operaters, i+1, end);
            mergelist(left, right, res, operaters.get(i));
        }
        return res;
    }

    private void mergelist(List<Integer> left, List<Integer> right, List<Integer> res, String operator){
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                int num = operate(left.get(i), right.get(j), operator);
                res.add(num);
            }
        }
    }

    private int operate(int i, int j, String operator){
        switch (operator){
            case "+":
                return i+j;
            case "-":
                return i-j;
            case "*":
                return i*j;
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "2*3-4*5";
        System.out.println(solution.diffWaysToCompute(test));
    }
}
