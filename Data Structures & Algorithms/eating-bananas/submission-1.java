class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right=0;
        int left=1;//min speed
        for(int pile:piles){
            right=Math.max(right, pile);//assing max value to right for max speed
        }
        //< used here not, <= as if left = right, means only one element remaining, and that is answer
        while(left<right){
            int mid=left+(right-left)/2;
            if(kokoBanana(piles, h, mid)){
                right=mid;//assign right as mid, which is possible, but need to find lower if there is
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    //private helper method
    private boolean kokoBanana(int[] piles, int h, int mid){
        //how many hours we need, it should be less than or equal to h
        int hours=0;
        for(int pile:piles){
            //formula: (a+b-1)/b for ceil(a/b)
            hours=hours+(pile+mid-1)/mid;
            //optimization, if hours is more than allowed, return immedicately false
            if(hours>h){
                return false;
            }
        }
        return true;
    }
}
