class Solution {
    public int maxProfit(int[] prices) {
        //in this sliding window, use left pointer at 0 and right at 1
        int l=0;
        int r=1;
        int res=0;
        // condition till right pointer is less than length
        while(r<prices.length){
            //if left pointer(buy) is small, then find profit
            if(prices[l]<prices[r]){
                int profit=prices[r]-prices[l];
                res=Math.max(res, profit);
            }
            //otherwise move buy to next day which is minimum
            else{
                l=r;
            }
            //keep incrementing sell day as this is the condition
            r++;
        }
        return res;
    }
}
