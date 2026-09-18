class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for(int i = 0 ;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == '{' || curr == '[' || curr == '('){
                st.push(curr);
            }else if(st.isEmpty()){
                return false;
            }else if((curr == '}' && st.peek()=='{') || (curr == ']' && st.peek()=='[') || (curr == ')' && st.peek()=='(')){
                st.pop();
            }else{
                return false;
            }
        }

        return st.isEmpty();
    }
}