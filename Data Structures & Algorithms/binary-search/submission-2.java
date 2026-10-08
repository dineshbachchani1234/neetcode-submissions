class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        //equal to and less than: remember this
        while(l<=r){
            //that's formula to find mid, kind of 
            int mid=l+((r-l)/2);
            if(nums[mid]>target){
                //move r to mid -1
                r=mid-1;
            }
            //move l to mid +1
            else if(nums[mid]<target){
                l=mid+1;
            }
            //otherwise return mid
            else{
                return mid;
            }
            }
            return -1;
    }
}
