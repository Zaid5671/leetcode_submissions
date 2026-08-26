class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l =0;
        int minLen = Integer.MAX_VALUE;
        String subS = "";

        for(int r = 0;r<s.length();r++){
            if(s.charAt(r)=='1'){
                k--;
            }

            while(k==0){
                int currLen = r-l+1;
                String currSs = s.substring(l,r+1);//since last index is excluded
                if(currLen<minLen){
                    minLen = currLen;
                    subS = currSs;
                }
                // i did't knew compareTo method compare string lexographically hence not solved due to code gap
                // also took a bit of hint for writign cmp logic rest all done by me
                else if(currLen == minLen){
                    //returns < 0 if currSs is lexicographically smaller
                    if(currSs.compareTo(subS)<0){
                        subS = currSs;
                    }
                }
                if(s.charAt(l)=='1'){
                    k++;
                }
                l++;
            }
        }
        
        return subS;
    }
}