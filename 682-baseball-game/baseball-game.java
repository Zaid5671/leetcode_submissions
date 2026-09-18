class Solution {
    public int calPoints(String[] a) {
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0;i<a.length;i++){
            String curr = a[i];
            if(curr.equals("+")){
                int num1 = st.pop();
                int num3 = num1+st.peek();
                st.push(num1);
                st.push(num3);
            }else if(curr.equals("C")){
                st.pop();
            }else if(curr.equals("D")){
                st.push(st.peek()*2);
            }else{
                st.push(Integer.parseInt(curr));
            }
        } 

        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}