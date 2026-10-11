class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums,int l,int r){
        if(l>=r)return;// there is only one single element hence sorted
        int mid = l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    public void merge(int[] nums,int l, int mid, int r){
        int[] ans = new int[r-l+1];
        int k = 0;
        int i = l;
        int j = mid+1;
        while(i<=mid && j<=r){
            if(nums[i]<=nums[j]){
                ans[k] = nums[i];
                i++;
            }else{
                ans[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            ans[k] = nums[i];
            i++;
            k++;
        }
        while(j<=r){
            ans[k] = nums[j];
            j++;
            k++;
        }
        //assign to org array
        for(int p = 0;p<ans.length;p++){
            nums[l+p] = ans[p];
        }
    }
}