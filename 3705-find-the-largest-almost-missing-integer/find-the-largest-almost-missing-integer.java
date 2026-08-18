class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int n = nums.length;
        int max = -1;
        if(k==1){
            for(int i = 0;i<n;i++){
                freq[nums[i]]++;
            }
            for(int i = 0;i<51;i++){
                if(freq[i]==1){
                    max = i;
                }
            }
        }else if(k==n){
            for(int i : nums){
                max = Math.max(max,i);
            }
        }
        else{
            int l = nums[0];
            int r = nums[n-1]; 
            if(l==r){
                l = -1;
                r = -1;
            }
            for(int i = 1;i<n-1;i++){
                if(nums[i]==l){
                    l = -1;
                }
                if(nums[i]==r){
                    r = -1;
                }
            }
            max = Math.max(max,Math.max(l,r));
        }

        return max;
    }
}