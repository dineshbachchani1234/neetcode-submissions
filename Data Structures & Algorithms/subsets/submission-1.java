class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracking(int[] nums, int start, List<Integer> subset, 
    List<List<Integer>> result){
        //empty subset list as base case
        result.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++){
            subset.add(nums[i]);
            backTracking(nums, i+1, subset, result);
            subset.remove(subset.size()-1);
        }

    }
}
