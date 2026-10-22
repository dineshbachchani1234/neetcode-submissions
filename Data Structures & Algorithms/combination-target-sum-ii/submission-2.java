class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //sorting to remove duplicates
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracking(int[] candidates, int remainingTarget, int start, 
    List<Integer> subset, List<List<Integer>> result){
        //base condition
        if(remainingTarget==0){
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            //skip duplicates
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            //if value become greater, no need to check further values as sorted
            if(candidates[i]>remainingTarget){
                break;
            }
            subset.add(candidates[i]);
            //no duplicates so i+1
            backTracking(candidates, remainingTarget-candidates[i], i+1, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
