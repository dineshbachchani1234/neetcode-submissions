class Solution {
    public int findMin(int[] nums) {
       int left=0;
       int right=nums.length-1;
       int ans=Integer.MAX_VALUE;
       //same binary search condition
       while(left<=right){
        int mid=left+(right-left)/2;
        //find which half is sorted, and take min value from there, and discard it
        if(nums[left]<=nums[mid]){
            //left half is sorted, take min, and increment left to mid+1 to discard left half
            ans=Math.min(ans, nums[left]);
            left=mid+1;
        }
        else{
            //right half is sorted, take min which is MID, and discard right half
            ans=Math.min(ans, nums[mid]);
            right=mid-1;
        }
       }
       return ans; 
    }
}
