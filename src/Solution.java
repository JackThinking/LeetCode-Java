import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Citrix on 2018/6/10.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> maps = new LinkedHashMap<Character, Integer>();
        HashMap<Character, Integer> mapt = new LinkedHashMap<Character, Integer>();
        char[] arrs = s.toCharArray();
        char[] arrt = t.toCharArray();
        for(char c : arrs){
            if(maps.containsKey(c)){
                maps.put(c,maps.get(c)+1);
            }
            else{
                maps.put(c,1);
            }
        }
        for(char c : arrt){
            if(mapt.containsKey(c)){
                mapt.put(c,mapt.get(c)+1);
            }
            else{
                mapt.put(c,1);
            }
        }
        return (maps.equals(mapt))? true:false;
        /*int[] chardci = new int[26];
        for(char c : s.toCharArray()){
            chardci[c-'a']++;
        }
        for(char c : t.toCharArray()){
            chardci[c-'a']--;
        }
        for(int i : chardci){
            if(i!=0){
                return false;
            }
        }
        return true;*/
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = new String("anagram");
        String t = new String("nagaram");
        System.out.println(solution.isAnagram(s,t));
    }
}

