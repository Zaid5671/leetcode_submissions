class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = -1;
        for(int i : piles){
            r = Math.max(r,i);
        }
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isOkay(mid,piles,h)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean isOkay(int k, int[] piles , int h){
        long count = 0;
        for(int num : piles){
            count += num/k;
            if(k != 1 && num%k != 0){
                count++;
            }
        }
        if(count<=h){
            return true;
        }
        else{
            return false;
        }
    }
}
