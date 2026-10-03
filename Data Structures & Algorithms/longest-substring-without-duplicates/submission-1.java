class Solution {
    public int lengthOfLongestSubstring(String s) {
        //use sliding window where l=0, r=0 and keep incrementing r in window
        int l=0;
        int res=0;
        Set<Character> set = new HashSet<>();
        for(int r=0;r<s.length();r++){
            //check if r is already in the set or not,
            //if yes, remove l from set, increment it, note the max length
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            //keep adding the element "r" in the set
            //we already remove l above if r is equal to l(already in set)
            set.add(s.charAt(r));
            //find the max length till now
            res=Math.max(res, r-l+1);
        }
        return res;
    }
}
