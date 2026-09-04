class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[nums.length-1]<target)return nums.length;
        int l = 0;
        int r = nums.length-1;
        int pos = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                pos = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return pos;
    }
}