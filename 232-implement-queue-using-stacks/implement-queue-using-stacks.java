class MyQueue {
    Deque<Integer> st1;
    Deque<Integer> st2;
    public MyQueue() {
        st1 = new ArrayDeque<>();
        st2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        // trasfer evrything to st2
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int toReturn = st2.pop();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return toReturn;
    }
    
    public int peek() {
        // trasfer evrything to st2
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int toReturn = st2.peek();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return toReturn;
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */