class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracking(int[] nums, int remainingTarget, int start, List<Integer> subset,
    List<List<Integer>> result){
        //base case
        if(remainingTarget==0){
            result.add(new ArrayList<>(subset));
            return;
        }
        //negative scenario, simply return
        if(remainingTarget<0){
            return;
        }
        //same loop
        for(int i=start; i<nums.length;i++){
            subset.add(nums[i]);
            //duplicates are allowed, so using i and not i+1
            backTracking(nums, remainingTarget-nums[i], i, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
