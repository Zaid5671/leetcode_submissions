class Solution {
    public int longestSubsequence(int[] nums) {
        int sum = 0;
        boolean isNotZero = false;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
            if (nums[i] != 0) {
                isNotZero = true;
            }
        }
        if (sum != 0) {
            return nums.length;
        } else if (isNotZero) {
            return nums.length - 1;
        } else {
            return 0;
        }
    }
}