class Solution {
    public boolean stoneGameIX(int[] nums) {
        int b0 = 0;
        int b1 = 0;
        int b2 = 0;

        for(int i : nums){
            if(i%3==0)b0++;
            else if(i%3==1)b1++;
            else b2++;
        }

        if(b0%2==0){
            if(b1>0 && b2>0){
                return true;
            }
            else{
                return false;
            }
        }else{
            if(Math.abs(b1-b2)>2){
                return true;
            }else{
                return false;
            }
        }
    }
}