package TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Method {
//    下面注释中的方法会出现同一个元素使用两遍的情况，因为hashMap.containsKey会在所有键中进行搜索
//    public int[] twoSum(int[] nums, int target) {
//
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            hashMap.put(nums[i], i);
//        }
//        for(int i = 0; i<nums.length; i++){
//            if(hashMap.containsKey(target-nums[i]))
//                return new int[]{i, hashMap.get(target-nums[i])};
//        }
//        return new int[]{0};
//    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(hashMap.containsKey(target-nums[i]))
                return new int[]{i, hashMap.get(target-nums[i])};
            hashMap.put(nums[i], i);
        }

        return new int[]{0};
    }

}

