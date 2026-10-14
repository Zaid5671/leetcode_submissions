class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        mergeSort(nums,0,n-1);

        return nums;
    }
    void mergeSort(int[] nums, int l, int r){
        if(l>=r)return;
        int mid = l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    void merge(int[] nums,int l, int mid, int r){
        int size = r-l+1;
        int[] arr = new int[size];

        int l1 = l;
        int l2 = mid+1;

        int k = 0;

        while(l1<=mid && l2<=r){
            if(nums[l1]<=nums[l2]){
                arr[k] = nums[l1];
                l1++;
            }else{
                arr[k] = nums[l2];
                l2++;
            }
            k++;
        }
        while(l1<=mid){
            arr[k] = nums[l1];
            l1++;
            k++;
        }
        while(l2<=r){
            arr[k] = nums[l2];
            l2++;
            k++;
        }
        // replace elements
        for(int i = 0;i<size;i++){
            nums[i+l] = arr[i];
        }
    }
}