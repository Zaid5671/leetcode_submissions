class MyCircularQueue {
    int[] q;
    int front;
    int rear;
    int size;
    public MyCircularQueue(int k) {
       this.q = new int[k];
       // intialize to 0 instead of -1 so that at first insertion both are at 0
       front = 0;
       rear = -1;
       size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        // if(size == 0){
        //     front = 0;
        //     rear = 0;
        // }else{

        rear = (rear+1)%q.length;
        q[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        size--;
        // if(rear == front){
        // not needed cause the operations are circulr
        //     front = -1;
        //     rear = -1;
        //     return true;
        // }
        front = (front+1)%q.length;
        return true;
    }
    
    public int Front() {
        if(isEmpty())return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty())return -1;
        return q[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */