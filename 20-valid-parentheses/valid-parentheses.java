class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();


        for(int i = 0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{'){
                st.push(curr);
            }
            else{
                if(st.isEmpty())return false;
                char top = st.peek();
                if((top == '{' && curr == '}') || (top == '(' && curr == ')') || (top == '[' && curr == ']')){
                    st.pop();
                }else{return false;}
            }
        }

        return st.isEmpty();
    }
}