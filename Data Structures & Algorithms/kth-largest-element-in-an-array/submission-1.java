class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        //assign all values in the min Heap
        for(int num: nums){
            minHeap.offer(num);
            //if minHeap becomes greater than 'k' then
            //remove the unwanted element
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        //return the first element of the minHeap
        return minHeap.peek();
    }
}
