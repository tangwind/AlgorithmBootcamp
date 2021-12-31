package first;

import java.util.Arrays;

public class PlusOneTest {
    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        int[] nums = plusOne(digits);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        return nums;
    }
}
