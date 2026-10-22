class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTracking(result, "", 0, 0, n);
        return result;
    }

    private void backTracking(List<String> result, String current, int open,
    int close, int max){
        //base condition
        if(current.length()==max*2){
            result.add(current);
            return;
        }

        //if we can add more open bracket or not
        if(open<max){
            backTracking(result, current + "(", open+1, close, max);
        }
        //if need to add close bracket or not
        if(close<open){
            backTracking(result, current + ")", open, close+1, max);
        }
        
    }
}
