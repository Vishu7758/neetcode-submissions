class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String ch : tokens) {
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                switch(ch) {
                    case "+": st.push(a+b); break;
                    case "-": st.push(a-b); break;
                    case "*": st.push(a*b); break;
                    case "/":
                    if(b!=0) st.push(a/b);
                    else st.push(0);
                    break;
                }
            } else {
                st.push(Integer.valueOf(ch));
            }
        }
        return st.pop();
    }
}
