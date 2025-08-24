class MyStack {
    int size;
     Queue<Integer> q1;
      Queue<Integer> q2;


    public MyStack() {
        int size=0;
        q1 = new LinkedList<>();
       q2  = new LinkedList<>();
    }
    
    public void push(int x) {
        size++;
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.poll());
            
        }
         Queue<Integer> q = q1;
         q1=q2;
         q2=q;

    }
    
    public int pop() {
        if(q1.isEmpty())
         return -1;
         size--;
         return q1.poll();
    }
    
    public int top() {
       if(q1.isEmpty())
         return -1;
         
         return q1.peek(); 
    }
    
    public boolean empty() {
        return size==0;
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