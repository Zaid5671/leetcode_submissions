class Solution {
    public boolean isPalindrome(String s) {
        String ans = strip(s);
        // System.out.println(ans);
        int n = ans.length();
    
        for(int i = 0;i<n/2;i++){
            if(ans.charAt(i) != ans.charAt(n-1-i))return false;
        }  
        return true;
    }

    public String strip(String s) {
        if (s == null)
            return null;

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(Character.isLetterOrDigit(curr)) {
                sb1.append(Character.toLowerCase(curr));
            }
        }
        return sb1.toString();
    }

}