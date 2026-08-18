class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        
        // Build the frequency map once for all cases
        for (int num : nums) {
            freq[num]++;
        }
        
        int max = -1;
        
        if (k == n) {
            // If k == n, we just want the maximum element present in the array
            for (int i = 0; i <= 50; i++) {
                if (freq[i] > 0) {
                    max = i; 
                }
            }
        } else if (k == 1) {
            // If k == 1, we want the maximum element that appears exactly once
            for (int i = 0; i <= 50; i++) {
                if (freq[i] == 1) {
                    max = i;
                }
            }
        } else {
            // If 1 < k < n, only the first and last elements can be in exactly 1 subarray.
            // They are valid only if their total frequency in the array is exactly 1.
            if (freq[nums[0]] == 1) {
                max = nums[0];
            }
            if (freq[nums[n - 1]] == 1) {
                max = Math.max(max, nums[n - 1]);
            }
        }
        
        return max;
    }
}