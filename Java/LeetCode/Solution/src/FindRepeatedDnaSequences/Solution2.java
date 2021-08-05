package FindRepeatedDnaSequences;

import java.util.*;

/**
 * Rabin-Karp：使用旋转哈希实现常数时间窗口切片
 */
public class Solution2 {
    public static List<String> findRepeatedDnaSequences(String s) {

        if (s.length() < 10) {
            return new ArrayList<>();
        }

        Map<Character, Integer> toInt = new
                HashMap() {{
                    put('A', 0);
                    put('C', 1);
                    put('G', 2);
                    put('T', 3);
                }};
        int[] nums = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            nums[i] = toInt.get(s.charAt(i));
        }

        Set<Integer> hashNum = new HashSet<>();
        Set<String> output = new HashSet<>();
        int L = 10, a = 4;
        int h0 = 0;

        for (int i = 0; i < s.length() - L + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    h0 += (int) Math.pow(a, L - j - 1) * nums[i + j];
                }
                hashNum.add(h0);
            } else {
                h0 = h0 * a - nums[i - 1] * (int) Math.pow(a, L) + nums[i + L - 1];
                if (hashNum.contains(h0)) {
                    String tmp = s.substring(i, i + L);
                    output.add(tmp);
                } else {
                    hashNum.add(h0);
                }
            }
        }
        return new ArrayList<String>(output);
    }


}
