class Solution {
    public int maxArea(int[] heights) {
        //2 pointer
        int res=0;
        int l=0;
        int r=heights.length-1;
        while(l<r){
            //find area
            int area=Math.min(heights[l], heights[r])*(r-l);
            //assign the max
            res=Math.max(res, area);
            //move either l or whichever is small
            if(heights[l]<heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
