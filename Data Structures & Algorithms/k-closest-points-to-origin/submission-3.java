class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //square of element and compare and sort
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->
        Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1]));
        //store all the elements in maxHeap
        for(int[] point:points){
            maxHeap.offer(point);
            //if maxHeap overflow, remove the first element which is farthest
            //so this element we don't need
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        //result array to store result
        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=maxHeap.poll();
        }
        return result;
    }
}
