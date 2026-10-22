class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTracking(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracking(String s, int start, List<String> subset, 
    List<List<String>> result){
        //base case
        if(start==s.length()){
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int i=start;i<s.length();i++){
            String subString = s.substring(start, i+1);
            //add only if pallindrom and then call backtrack method
            if(isPallindrome(subString)){
                subset.add(subString);
                backTracking(s, i+1, subset, result);
                subset.remove(subset.size()-1);
            }
        }
    }


    private boolean isPallindrome(String s){
        //define start and end
        int start=0;
        int end=s.length()-1;
        //while loop till start is less than end
        while(start<end){
            //if both are not equal, means not pallindrome, return false
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            //keep incrementing start and decrementing end
            start++;
            end--;
        }

        //if it is pallidrome, return true
        return true;
    }
}
