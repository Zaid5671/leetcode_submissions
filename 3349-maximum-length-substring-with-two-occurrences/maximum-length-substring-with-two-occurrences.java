class Solution {
    public int maximumLengthSubstring(String s) {
        int l = 0;
        int[] freq = new int[26];
        int maxLen = 0;
        for(int r = 0;r<s.length();r++){
            int curr = s.charAt(r)-'a';
            freq[curr]++;
            while(freq[curr]>2){
                freq[s.charAt(l)-'a']--;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}