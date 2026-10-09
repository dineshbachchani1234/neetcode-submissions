class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find overall size in m and n
        int m=matrix.length;
        int n=matrix[0].length;
        //assign left and right based on overall size
        int left=0;
        int right=m*n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //main logic, where we are converting in 2D by finding row col
            int row=mid/n;
            int col=mid%n;
            //same conditions
            if(target==matrix[row][col]){
                return true;
            }
            else if(target>matrix[row][col]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
}
