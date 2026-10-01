class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        //loop till left is smaller than right
        while(left<right){
            //increment left if it is not alphanumeric
            while(left<right && !isAlpha(s.charAt(left))){
                left++;
            }
            //decrement right if it is not alphanumeric
            while(left<right && !isAlpha(s.charAt(right))){
                right--;
            }
            //check character at both position left and right, if not equal then false,
            //otherwise, keep incrementing left and decrementing right
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
                left++;
                right--;
            }

            //nothing happens, return true
        return true;
    }

    //method to check alphanumeric, no need to remember this
    private boolean isAlpha(char c){
        if((c>='A' && c<='Z')||
        (c>='a' && c<='z') ||
        c>='0' && c<='9'
        ){
            return true;
        }
        return false;

    }
}
