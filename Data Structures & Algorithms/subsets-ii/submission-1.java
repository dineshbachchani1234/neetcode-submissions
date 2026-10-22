class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracking(int[] nums, int start, List<Integer> subset, 
    List<List<Integer>> result){
        //base condition
        result.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++){
            //remove duplicate
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            backTracking(nums, i+1, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
