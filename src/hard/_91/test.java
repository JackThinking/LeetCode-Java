package hard._91;

/**
 * Created by Citrix on 2018/10/24.
 */
public class test {
    public int numDecodings(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int n = s.length();
        int pre = 1;
        int now = s.charAt(n - 1) == '0' ? 0 : 1;
        int curr = now;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                curr = 0;
            } else {
                curr = Integer.parseInt(s.substring(i, i + 2)) < 27 ? pre + now : now;
            }
            pre = now;
            now =curr;
        }

        return curr;
    }
}
