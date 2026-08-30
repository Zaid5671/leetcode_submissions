class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIdx = -1;
        int minIdx = -1;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i]<min){
                min = nums[i];
                minIdx = i;
            }
        }
        int big = -1;
        int small = -1;
        if(minIdx>maxIdx){
            big = minIdx;
            small = maxIdx;
        }else{
            big = maxIdx;
            small = minIdx;
        }
        System.out.println(big + " " + small);
        return Math.min(big+1,Math.min(((nums.length-big)+(small+1)),nums.length-small));
    }
}