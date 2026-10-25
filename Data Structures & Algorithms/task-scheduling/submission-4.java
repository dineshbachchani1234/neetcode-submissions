class Solution {
    public int leastInterval(char[] tasks, int n) {
        //let's first take frequencey of each task
        int[] count = new int[26];
        for(char task:tasks){
            count[task-'A']++;
        }
        //use the max heap, as we need most frequent items
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //add frequency in the maxheap
        for(int c:count){
            //only use positive frequency, so element should come atlease 1 time
            if(c>0){
            maxHeap.offer(c);
            }
        }
        //this is the answer we need to find
        int time=0;
        //queue for the cooldown period
        //0 position - remaining count of task
        //1 position - after how much time, this task will be available
        Queue<int[]> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            //always increment time no matter work or idle
            time++;
            //if maxHeap is empty, just add the idle time from queue, as nothing to work
            //Note: Using PEEK here not POLL, as we should not remove that task from queue
            if(maxHeap.isEmpty()){
                time=queue.peek()[1];
            }
            //if some task is present to work, decrement it's counter, and check
            //if count is still more than 0, then add back to queue with 
            //updated count and cool down period
            else{
                int c=maxHeap.poll()-1;
                if(c>0){
                    queue.offer(new int[]{c, time+n});
                }
            }
            //queue not empty, and first element(cooldown period) is equal to time
            if(!queue.isEmpty() && queue.peek()[1]==time){
                //add to heap so we can do the tak
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
