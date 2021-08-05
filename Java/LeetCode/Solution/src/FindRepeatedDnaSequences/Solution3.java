package FindRepeatedDnaSequences;

import java.util.*;

/**
 * 掩码
 */
public class Solution3 {
    public static List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10) {
            return new ArrayList<>();
        }

        Map<Character, Integer> toInt = new HashMap<>(){{put('A', 0); put('C',1); put('G', 2); put('T', 3); }};
        int[] nums = new int[s.length()];
        int L= 10;
        for(int i = 0; i<s.length(); i++) {
            nums[i] = toInt.get(s.charAt(i));
        }
        Set<Integer> masks = new HashSet<>();
        Set<String> output = new HashSet<>();
        int mask = 0;
        for(int i = 0; i<s.length()-L+1; i++) {
            if(i == 0) {
                for(int j = 0; j<L; j++) {
                    mask<<=2;
                    mask|=nums[j];

                }
            masks.add(mask);
            } else {
                mask <<=2; //左移两位, 释放两个最低位
                mask |= nums[i+L-1]; //添加两个最低位
//                mask = mask & 0011111111111111111111; //最高两位置0
//                mask = mask & ~(0000000000000000000011 << 2*L);
//                mask = mask & ~(3 << 2*L);
                mask&=~(3<<2*L);
                if(masks.contains(mask)) {
                    String tmp = s.substring(i,i+L);
                    output.add(tmp);
                } else {
                    masks.add(mask);
                }
            }
        }
        return new ArrayList<String>(output);
    }
    public static void main(String[] args) {
        String s = "CAAAAAAAAAC";
        findRepeatedDnaSequences(s);
    }
}
