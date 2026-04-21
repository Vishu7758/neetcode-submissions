class MinStack {
    Stack<Pair<Integer, Integer>> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = st.isEmpty()? val : Math.min(st.peek().getKey(), val);
        st.push(new Pair<>(min, val));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().getValue();
    }
    
    public int getMin() {
        return st.peek().getKey();
    }
}
