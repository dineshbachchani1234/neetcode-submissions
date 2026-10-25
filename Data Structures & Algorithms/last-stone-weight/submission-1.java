class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        
        //let's store all the stones in maxHeap
        for(int stone:stones){
            maxHeap.offer(stone);
        }
        //till heap have at least 2 elements
        while(maxHeap.size()>1){
            int largest=maxHeap.poll();
            int secondLargest=maxHeap.poll();
            int difference=largest-secondLargest;
            if(difference>0){
                maxHeap.offer(difference);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}
