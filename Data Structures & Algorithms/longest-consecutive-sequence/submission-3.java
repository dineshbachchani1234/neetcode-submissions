class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //assign all values in set, as remove duplicates
        for(int num:nums){
            set.add(num);
        }
        //longest for time being as 0
        int longest=0;
        //travel each element in set only if it's the start of sequence
        //start of sequence if num-1 is not present
        for(int num: set){
            if(!set.contains(num-1)){
                //initialize length as 1, so we will keep incrementing this
                int length=1;
                //keep incremeting till we are finding the sequence,
                //once sequence breaks, then next num, but before that,
                // assign length to longest. So this is our sequence till now
                while(set.contains(num+length)){
                    length++;
                }
                longest=Math.max(longest, length);
            }
        }
        return longest;
        
    }
}
