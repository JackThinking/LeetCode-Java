package hard._140;

import java.util.*;

/**
 * Created by Citrix on 2018/7/14.
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<Integer, List<String>>(),0);
    }
    public List<String> dfs(String s, List<String> dict, Map<Integer, List<String>> map, int start) {
        if (map.containsKey(start)) return map.get(start);//剪枝，较少不必要的寻找
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");//??
            return res;//结束的return
        }
        for (String word : dict) {
            if (s.startsWith(word, start)) {
                List<String> sublist = dfs(s, dict, map, start + word.length());
                for (String n : sublist) {
                    res.add(word + (n.length() == 0 ? "" : " ") + n);
                }

            }
        }
        map.put(start, res);
        return res;//寻找过程的return
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "pineapplepenapple";
        List<String> word = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(solution.wordBreak(s,word));
    }
}