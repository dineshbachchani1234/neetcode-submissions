class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0]=1;
        //prefix
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i-1]*res[i-1];
        }
        //suffix
        int suffix=1;
        //so now result array already have the prefix,
        //if we multiply result with suffix, we get the result,
        //but keep updating the suffix
        for(int i=nums.length-1;i>=0;i--){
            //suffix is 1 for last element, and result[last element] is prefix
            //so 1* last element = result of last element(prefix*suffix)
            //suffix becomes suffix * that element, for next element(backward)
            res[i]=res[i]*suffix;
            suffix=suffix*nums[i];
        }

        return res;
    }
}  
