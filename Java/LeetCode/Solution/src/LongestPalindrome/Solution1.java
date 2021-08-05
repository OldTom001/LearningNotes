package LongestPalindrome;

public class Solution1 {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
//        status[i][j]表示s的第i个元素到第j个元素组成的子串是否为回文串
        boolean[][] status = new boolean[len][len];
        int maxLen = 1;
        int beginInd = 0;
        for (int i = 0; i < len; i++) {
            status[i][i] = true; //长度为1的都是回文串
        }
//        L代表子串长度
        for (int L = 2; L <= len; L++) {
//            i表示子串起点
            for (int i = 0; i < len - L + 1; i++) {
//                j表示子串终点
                int j = i + L - 1;
                if (s.charAt(j) != s.charAt(i)) {
                    status[i][j] = false;
                } else {
                    if (j - i < 3) {
                        status[i][j] = true;
                    } else {
                        status[i][j] = status[i + 1][j - 1];
                    }
                }
                if (status[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    beginInd = i;

                }
            }

        }
        return s.substring(beginInd, beginInd + maxLen);
    }
}
