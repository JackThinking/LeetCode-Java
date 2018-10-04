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
        Set<String> words = new HashSet<>();//...
        for (String word : wordList
        ) {
            words.add(word);
        }
        if (!words.contains(endWord)) {
            return 0;
        }
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        List<String> next = null;
        int level = 1;
        while (!curr.isEmpty()) {
            next = new ArrayList<>();
            for (String word : curr) {
                if (word.equals(endWord)) {
                    return level;
                }
                next.addAll(getNext(word, words));
            }
            level++;
            curr = next;
        }
        return 0;
    }

    private List<String> getNext(String word, Set<String> words) {//函数的作用是找出words中与word只差一字只差的序列，并将其删除
        List<String> res = new ArrayList<>();
        int count;
        for (String w : words) {
            count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (w.charAt(i) != word.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                res.add(w);
            }
        }
        words.removeAll(res);
        return res;
    }
}