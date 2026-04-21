class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(var ch : s.toCharArray()) {
            if(ch=='(' || ch=='[' || ch=='{') st.push(ch);
            else {
                if(st.size()==0) return false;
                if((st.peek()=='(' && ch==')') ||
                (st.peek()=='[' && ch==']') ||
                (st.peek()=='{' && ch=='}')) st.pop();
                else return false;
            }
        }
        return st.size()==0;
    }
}
