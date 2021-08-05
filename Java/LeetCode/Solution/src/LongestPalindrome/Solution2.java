package LongestPalindrome;

import java.util.Map;

public class Solution2 {

    /**
     * 中心扩展算法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int beginInd = 0;
        int len = s.length();
//        从单个中心进行扩散, i是扩散中心, L是扩散长度
        for(int i = 1; i<len-1; i++) {
            int L =1;
            while(i-L>=0 && i+L <len) {
                if(s.charAt(i-L)!=s.charAt(i+L)) {
                    break;
                }
                if(1+2*L>maxLen){
                    beginInd = i-L;
                    maxLen = 1+2*L;
                }
                L++;
            }
        }
//        从双中心进行扩散, i是扩散中心, L是扩散长度
        for(int i = 0; i<len-1; i++) {
            if(s.charAt(i)!=s.charAt(i+1)) {
                continue;
            }
            int L = 0;
            while (i-L>=0 &&i+1+L<len) {
                if(s.charAt(i-L) != s.charAt(i+1+L)) {
                    break;
                }
                if(2+2*L>maxLen) {
                    beginInd = i-L;
                    maxLen=2+2*L;
                }
                L++;
            }
        }
        return s.substring(beginInd,maxLen+beginInd);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        longestPalindrome(s);
    }
}
