class Solution {
    public String removeOuterParentheses(String s) {
        // opening coutn and closing count maintain
        int open = 0;
        int close = 0;
        StringBuilder ans = new StringBuilder();
        open++;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){// dont append
                i++;
                open++;
                continue;
            }else{
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}