import java.util.*;

public class Method {
    public static boolean wordPattern(String pattern, String s) {
        s.split()
        Map<Character, String> pat2str = new HashMap<>();
        Map<String, Character> str2pat = new HashMap<>();
        int k = 0; //用于提取s中的子串, k是起点, j是终点
        for (int i = 0; i < pattern.length(); i++) {
            if (k >= s.length()) {
                return false;
            }

            char ch = pattern.charAt(i);
            int j = k;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            String str = s.substring(k, j);

            if (pat2str.containsKey(ch) && !pat2str.get(ch).equals(str)) {
                return false;
            }
            if (str2pat.containsKey(str) && str2pat.get(str) != ch) {
                return false;
            }

            pat2str.put(ch, str);
            str2pat.put(str, ch);
            k = j + 1;

        }
        return k >= s.length(); //保证s中子字符串的数量和规则中字符的数量是一致的

    }

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
//        String pattern = "abba";
//        String s = "dog cat cat dog dog";
//        wordPattern(pattern, s);
        int i = 500;
        map.put("a", i);

    }
}