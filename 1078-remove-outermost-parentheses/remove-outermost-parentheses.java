class Solution {
    public String removeOuterParentheses(String s) {
        // opening coutn and closing count maintain
        int open = 0;
        int close = 0;
        List<Character> list = new ArrayList<>(); 
        open++;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){
                i++;
                open++;
                continue
                ;
            }else{
                list.add(s.charAt(i));
            }
        }

        String ans = "";
        for(int i = 0;i<list.size();i++){
            ans += list.get(i);
        }

        return ans;
    }
}