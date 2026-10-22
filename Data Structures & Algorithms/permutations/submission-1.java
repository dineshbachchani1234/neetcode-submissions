class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //not using start, and using this boolean list
        backTracking(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backTracking(int[] nums, List<Integer> subset, boolean[] used, 
    List<List<Integer>> result){
        //base condition
        //if size of subset is equal to length of array, found 1 answer here
        if(subset.size()==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        //no start, loop always everytime start with 0
        for(int i=0;i<nums.length;i++){
            //if element already have in iteration, skip it
            if(used[i]){
                continue;
            }
            subset.add(nums[i]);
            used[i]=true;
            backTracking(nums, subset, used, result);
            subset.remove(subset.size()-1);
            used[i]=false;
        }
        
    }
}
