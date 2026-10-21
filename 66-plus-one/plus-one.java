class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        digits[n-1] += 1;
        int carry = digits[n-1]/10;
        digits[n-1] %= 10;

        int i = n-2;
        while(i>=0 && carry != 0){
            digits[i] += carry;
            carry = digits[i]/10;    
            digits[i] %= 10;
            
            i--;
        }
        if(carry>0){
            //add element
            int[] ans = new int[n+1];
            ans[0] = carry;
            return ans;
        }

        return digits;
    }
}