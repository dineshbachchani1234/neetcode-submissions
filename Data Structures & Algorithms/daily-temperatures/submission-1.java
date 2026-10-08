class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //output array to store the difference when greater temperature comes
        int[] res = new int[temperatures.length];
        //stack to store both temperature and index(pair)
        Stack<int[]> stack = new Stack<>();
        //loop to travel all the temperatures
        for(int i=0;i<temperatures.length;i++){
            int ct=temperatures[i];
            //if current temperature is greater than stack top temperature
            while(!stack.isEmpty() && ct>stack.peek()[0]){
                //get top temperature and index
                int top[]=stack.pop();
                //result array store index difference
                //so, top[1] is the index of that temperature which finds greater temp
                //difference = i-index of this element
                res[top[1]]=i-top[1];
            }
            //store stack with temperaute and index
            stack.push(new int[]{ct,i});
        }
        return res;
    }
}
