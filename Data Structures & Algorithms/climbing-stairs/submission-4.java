class Solution {
    public int climbStairs(int n) {
        //int[] dp = new int[n+1];
        //dp[0]=1;//last step
        //dp[1]=1;//last 2nd
        int oneStepBack=1;//last second element(dp[1])
        int twoStepBack=1;//last element(dp[0])
        for(int i=2;i<=n;i++){
            // dp[i]=dp[i-1]+dp[i-2];
            //simple addition of last
            int current=oneStepBack+twoStepBack;
            //last becomes second last, in simple: last element out, last take second last value
            //second last take addition value which we find
            twoStepBack=oneStepBack;
            oneStepBack=current;
        }
        return oneStepBack;
    }
}
