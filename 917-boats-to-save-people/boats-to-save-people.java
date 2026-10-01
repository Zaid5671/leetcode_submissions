class Solution {
    public int numRescueBoats(int[] a, int limit) {
        Arrays.sort(a);
        int l = 0;
        int r = a.length-1;
        int c = 0;
        while(l<=r){
            int sum = a[l]+a[r];
            if(sum<=limit){
                l++;
                r--;
            }
            else{
                // send the max one
                r--;
            }
            c++;
        }
        return c;
    }
}