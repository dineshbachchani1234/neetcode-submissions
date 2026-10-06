class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String s:tokens){
            if(s.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int c=a+b;
                stack.push(c);
            }
            else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                int c=b-a;
                stack.push(c);
            }
            else if(s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                int c=b*a;
                stack.push(c);
            }
            else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int c=b/a;
                stack.push(c);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
