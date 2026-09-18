class MyCircularQueue {
    int[] q;
    int front;
    int rear;
    int k;
    int size;
    public MyCircularQueue(int k) {
        q = new int[k];
        front = 0;
        rear = -1;
        this.k = k;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        size++;
        rear = (rear+1)%k;
        q[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        if(front==rear){
            front = 0;
            rear = -1;
        }else{
            front = (front+1)%k;
        }
        size--;
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
        return rear == -1;
    }
    
    public boolean isFull() {
        return size == k;
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