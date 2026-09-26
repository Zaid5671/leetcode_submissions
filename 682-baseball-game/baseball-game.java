class Solution {
    public int calPoints(String[] o) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0;i<o.length;i++){
            String curr = o[i];
            if(curr.equals("+")){
                int num1 = st.pop();
                int num2 = st.peek()+num1;
                st.push(num1);
                st.push(num2);
            }else if(curr.equals("D")){
                st.push(st.peek()*2);
            }else if(curr.equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(curr));
            }
        }

        // sum of all vals
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }

        return sum;
    }
}