class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.minHeap=new PriorityQueue<>();
        //store all values of array in min Heap
        for(int num:nums){
            minHeap.offer(num);
            //if min heap is more than k elements, delete that, it will delete
            //the smallest, and we need largest, so that's fine
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        //add new value in minHeap
        minHeap.offer(val);
        //if minHeap exceed the limit, delete last one
        if(minHeap.size()>k){
            minHeap.poll();
        }
        //return the first element, which is kth largest
        return minHeap.peek();
        
    }
}
