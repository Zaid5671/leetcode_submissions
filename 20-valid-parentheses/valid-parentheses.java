class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(int i = 0;i<s.length();i++){
            Character curr = s.charAt(i);
            if(!st.isEmpty()){
                //check top and incoming element
                Character top = st.peek();
                if((top == '[' && curr == ']')||(top == '{' && curr == '}')||(top == '(' && curr == ')')){
                    st.pop();
                }
                else{/// push the curr element otherwise '({[)' will give true
                    st.push(curr);
                }
            }else{
                st.push(curr);
            }
        }

        return st.isEmpty();
    }
}