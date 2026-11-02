class Solution {
    public int minCostClimbingStairs(int[] cost) {
       
        int twoStepBack=0;  //stair 0, starting
        int oneStepBack=0;  //stair 1, 1 stair above
        for(int i=2;i<=cost.length;i++){
            int current=Math.min(twoStepBack+cost[i-2], oneStepBack+cost[i-1]);
            twoStepBack=oneStepBack;
            oneStepBack=current;
        }
        return oneStepBack;
    }
}
