class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='{' || c=='(' || c=='['){
                stack.push(c);
            }
            else{
                //this means, string have more characters, but stack is empty
                //uneven so, return false
                if(stack.isEmpty()){
                    return false;
                } 
                char top = stack.pop();
                if((c=='}' && top!='{')||
                (c==')' && top!='(')||
                (c==']' && top!='[')
                ){
                    return false;
                }
            }
        }
        //return true if stack is empty, otherwise false
        return stack.isEmpty();
    }
}
