class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() >s2.length())return false;
        int[] freq = new int[26];
        int l = 0;
        for(int i = 0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        for(int r = s1.length();r<s2.length();r++){
            if(isZero(s1,freq))return true;
            freq[s2.charAt(r)-'a']--;
            freq[s2.charAt(l)-'a']++;
            l++;
        }

        return isZero(s1,freq);
    }

    public boolean isZero(String s1, int[] freq){
        for(int i = 0;i<s1.length();i++){
            if(freq[s1.charAt(i)-'a'] != 0)return false;
        }
        return true;
    }
}