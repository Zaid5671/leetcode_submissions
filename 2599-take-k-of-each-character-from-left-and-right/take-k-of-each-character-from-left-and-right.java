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
        int maxSize = 0;
        for(int r = 0;r<n;r++){
            int curr = s.charAt(r)-'a'; 
            freq[curr]--;
            while(freq[curr]<k){
                freq[s.charAt(l)-'a']++;
                l++;
            }
            maxSize = Math.max(maxSize,r-l+1);
        }

        return n-maxSize;
    }
    
}