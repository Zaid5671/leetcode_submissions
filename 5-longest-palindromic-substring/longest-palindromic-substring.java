class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;

        int start = 0;
        for(int i = 0;i<n;i++){
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);
            int temp = Math.max(odd,even);

            if(temp>maxLen){
                maxLen = temp;
                start = i-(temp-1)/2;// (temp-1) works for both odd and even lens 
            }
        }
        return s.substring(start,start+maxLen);
    }
    public int expand(String s, int l, int r){
        int n = s.length();
        int count = 0;
        if(l == r){
            count++;
            l--;
            r++;
        }
        while(l>=0 && r<n){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                count += 2;
            }else{
                break;
            }
        }
        return count;
    }
}