package easy._125;

/**
 * Created by Citrix on 2018/6/11.
 */
public class Solution {
    public boolean isPalindrome(String s){
        /*String test = s.replaceAll("[^a-z^A-Z]", "").toLowerCase();
        char[] arr = test.toCharArray();
        for (int i = 0; i < arr.length/2; i++) {
            if(arr[i] != arr[arr.length-i-1]){
                return false;
            }
        }
        return true;*/
        if(s == null||s.length() == 0){ //null和0的判断是不是重复了？
            return false;
        }
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            char lc = s.charAt(i);
            char rc = s.charAt(j);
            if ((lc<65||lc>90)&&(lc<97||lc>122)&&(lc<48||lc>57)){
                i++;
                continue;
            }
            if ((rc<65||rc>90)&&(rc<97||rc>122)&&(rc<48||rc>57)){
                j--;
                continue;
            }
            if (lc!=rc){
                if (lc>=65 && lc<=90){
                    return (lc -'A') == (rc -'a');
                }
                if (lc>=97 && lc<=122){
                    return (lc -'a') == (rc -'A');
                }
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = new String("A man, a plan, a canal: Panama");
        System.out.println(solution.isPalindrome(s));
    }
}
