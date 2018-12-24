package medium._49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Citrix on 2018-12-24.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] dict = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        List<List<String>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strs) {
            int k = 1;
            for (char c : str.toCharArray()) {
                k *= dict[c - 'a'];
            }
            List<String> t;
            /*
             * 判断指纹是不是第一次出现以及出现的层数，用map来记录
             * */
            if (map.containsKey(k)) {
                t = res.get(map.get(k));//获取层数
            } else {
                t = new ArrayList<>();//新建新的template
                res.add(t);//添加进res里
                map.put(k, res.size() - 1);//在map中加入指纹
            }
            t.add(str);//在确定的层数插入字符
        }
        return res;
    }
}
