class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //if found the target, simply return
            if(nums[mid]==target){
                return mid;
            }
            //check if LEFT half sorted or not
            if(nums[left]<=nums[mid]){
                //check if target is in left sorted half or not
                if(nums[left]<=target && target<=nums[mid]){
                    //if yes, take that half
                    right=mid-1;
                }
                //otherwise, take other
                else{
                    left=mid+1;
                }
            }
            else{
                //right half is sorted
                //check if target is in right sorted half range or not
                if(nums[mid]<target && target<=nums[right]){
                    //check that if half, if yes
                    left=mid+1;
                }
                else{
                    //otherwise check other half
                    right=mid-1;
                }
            }
        }
        //not found, simply return
        return -1;
    }
}
