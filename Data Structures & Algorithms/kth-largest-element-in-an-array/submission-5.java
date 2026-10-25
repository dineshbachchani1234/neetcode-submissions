class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        //store all numbers in min heap
        for(int num:nums){
            minHeap.offer(num);
            //store only k elements so last element is our answer
            //if additional element come, remove that
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        //return the last element as that is our output
        return minHeap.peek();
    }
}
