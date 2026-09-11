class Solution {
    public int findMin(int[] a) {
        int l =0;
        int r = a.length-1;

        int min = Integer.MAX_VALUE;

        while(l<=r){
            int mid = l + (r-l)/2;
            min = Math.min(min,a[mid]);
            if(a[mid] <= a[l] && a[l]==a[r]){
                l++;
                r--;
                continue;
            }
            if(a[mid]<=a[r]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return min;
    }
}