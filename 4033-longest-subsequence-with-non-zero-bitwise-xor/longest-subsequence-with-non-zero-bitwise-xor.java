class Solution {
    public int longestSubsequence(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum ^= nums[i];  
        }
        if(sum != 0) return nums.length;

        for(int i = 0;i<nums.length;i++){
            if((sum^nums[i]) != 0){
                return nums.length-1;
            }
        }
        return 0;
    }
}