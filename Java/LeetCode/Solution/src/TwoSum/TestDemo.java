package TwoSum;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Method m = new Method();
        int[] result = m.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }
}
