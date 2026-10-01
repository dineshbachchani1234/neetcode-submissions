class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        //simple 2 pointer
        while(l<r){
            //check sum, if greater reduce right, if less increase left
            int sum=numbers[l]+numbers[r];
            if(sum>target){
                r--;
            }
            else if(sum<target){
                l++;
            }
            else{
                return new int[]{l+1, r+1};
            }
        }
        return new int[]{};
    }
}
