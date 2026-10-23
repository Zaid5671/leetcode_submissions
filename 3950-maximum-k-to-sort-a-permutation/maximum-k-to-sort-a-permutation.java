class Solution {
    public int sortPermutation(int[] nums) {
        // // sorted if nums[i] == i;      
        int n = nums.length;

        int k = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            if(nums[i] != i){
                k &= nums[i];
            }
        }
        if(k == Integer.MAX_VALUE)return 0;
        return k;
    }
}