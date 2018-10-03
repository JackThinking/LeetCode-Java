package hard._127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Citrix on 2018/10/3.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String word : wordList) {
            words.add(word);
        }
        if (!words.contains(endWord)) {
            return 0;
        }
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        List<String> next = null;//这边是因为while循环中要反复生成
        int level = 1;
        while (!curr.isEmpty()) {
            next = new ArrayList<>();
            for (String word : curr
            ) {
                if (word.equals(endWord)) {//TODO 不是==
                    return level;
                }
                next.addAll(getnext(word, words));//TODO
            }
            curr = next;//没想到，这个是逻辑重点
            level++;
        }
        return 0;
    }

    private List<String> getnext(String word, Set<String> words) {//TODO 返回类型搞不清楚
        List<String> next = new ArrayList<>();
        int diff = 0;
        for (String w : words
        ) {
            diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != w.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                next.add(w);
            }
        }
        words.removeAll(next);
        return next;
    }
}
