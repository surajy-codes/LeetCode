class MyQueue {

    Stack<Integer> inst;
    Stack<Integer> outst;

    public MyQueue() {
        inst=new Stack<>();
        outst=new Stack<>();
    }

    void shift(){
        if(outst.isEmpty()){
            while(!inst.isEmpty()) outst.push(inst.pop());
        }
    }
    
    public void push(int x) {
        inst.push(x);
    }
    
    public int pop() {
        shift();
        return outst.pop();
    }
    
    public int peek() {
        shift();
        return outst.peek();
    }
    
    public boolean empty() {
        return inst.isEmpty() && outst.isEmpty();
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