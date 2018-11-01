package hard._10;

/**
 * Created by Citrix on 2018/10/31.
 */
public class test {
    public boolean isMatch(String s, String p) {
        if ((s.length()== 0) && (p.length() == 0)) return true;//改写了
        return isMatch(s, p, s.length() - 1, p.length() - 1);
    }

    public boolean isMatch(String s, String p, int si, int pi) {
        /*
         * 先写结束条件
         * */
        if (si == -1 && pi == -1) {
            return true;
        } else if (pi < 0) {
            return si < 0;//这边不熟练
        }
        char pc = p.charAt(pi);
        if (pc == '*') {
            return (pi > 0 && si >= 0
                    && (p.charAt(pi - 1) == '.' || p.charAt(pi - 1) == s.charAt(si))
                    && isMatch(s, p, si - 1, pi))
                    || isMatch(s, p, si, pi - 2);
        } else if (si >= 0 && (pc == s.charAt(si) || pc == '.') && isMatch(s, p, si - 1, pi - 1)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aa";
        String p = "a*";
        System.out.println(solution.isMatch(s,p));
    }
}
