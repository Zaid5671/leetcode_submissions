class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    // no need to convert from Integer to int, java automatically does that
    public int pop() {
        int val = -1;
        while(true){
            val = q1.poll();
            if(q1.isEmpty()){
                break;
            }
            q2.offer(val);
        }
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return val;
    }
    
    public int top() {
        int val = -1;
        while(!q1.isEmpty()){
            val = q1.poll();
            q2.offer(val);
        }
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return val;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */