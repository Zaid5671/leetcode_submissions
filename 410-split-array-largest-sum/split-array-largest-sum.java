class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int totalSum = 0;
        int minMaxSum = 0;
        for(int n : nums){
            max = Math.max(max,n);
            totalSum += n;
        }
        int l = max;
        int r = totalSum;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(isOkay(mid,k,nums)){
                minMaxSum = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return minMaxSum;
    }
    public boolean isOkay(int maxSum, int k, int[] a){
        int currSum = 0;
        for(int i = 0;i<a.length;i++){
            currSum += a[i];
            if(currSum > maxSum){
                k--;
                currSum = a[i];
            }
            if(k <= 0)return false;
        }
        return true;
    }
}