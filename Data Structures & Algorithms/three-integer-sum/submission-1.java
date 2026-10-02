class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //n-2 as we need three elements so no need to go complete loop
        for(int i=0;i<nums.length-2;i++){
            //break if first element is positive, sum 0 never possible
            if(nums[i]>0){break;}
            //continue if the element is same
            if(i!=0 && nums[i]==nums[i-1]){continue;}
            //assign left and right pointer
            int l=i+1;
            int r=nums.length-1;
            //keep checking
            while(l<r){
                //find the sum and do the 2 SUM here
                int sum=nums[i]+nums[l]+nums[r];
                if(sum>0){
                    r--;
                }
                else if(sum<0){
                    l++;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    //check for the duplicates for "l"
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
