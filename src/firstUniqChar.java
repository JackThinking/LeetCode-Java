/**
 * Created by Citrix on 2018/6/9.
 */
public class firstUniqChar {
    public static int firstUniqCharok(String s) {
        int[] alp = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr){
            alp[c -'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(alp[arr[i] -'a'] == 1){
                return i;
            }

        }
        return -1;
    }
    public static void main(String[] args){
        String test = new String("loveleetcode");
        System.out.println(firstUniqCharok(test));
    }
}
