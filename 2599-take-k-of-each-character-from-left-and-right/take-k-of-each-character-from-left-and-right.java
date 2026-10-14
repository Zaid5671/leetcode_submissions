class Solution {
    public int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        int n = s.length();
        for(int i = 0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int count : freq){
            if(count<k)return -1;
        }
        int l = 0;
        int maxLen = 0;
        for(int r = 0;r<n;r++){
            freq[s.charAt(r)-'a']--;
            while(freq[s.charAt(r)-'a']<k){
                freq[s.charAt(l)-'a']++;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }

        return n-maxLen;
    }
}