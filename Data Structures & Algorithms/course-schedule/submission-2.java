class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we need adjacency list to see the dependency of each course
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        //let's add the dependency
        for(int[] preq:prerequisites){
            //so here 0 depends on 1
            list.get(preq[0]).add(preq[1]);
        }
        //initialize the state for all courses as unvisited
        //0 unvisited
        //1 visiting(current)
        //2 visited(done)
        int[] state = new int[numCourses];

        //check cycles in all courses
        for(int i=0;i<numCourses;i++){
            if(hasCycle(i, list, state)){
                return false;
            }
        }
        return true;
    }


    private boolean hasCycle(int course, List<List<Integer>> list, int[] state){
        //early exit if 2 means already done, return false, no cycle
        if(state[course]==2){
            return false;
        }
        //cycle, coming back, so return true
        if(state[course]==1){
            return true;
        }
        //if nothing, then mark this course as visiting
        state[course]=1;

        //find dependency of that course
        for(int preq:list.get(course)){
            //so we will loop again for that course with all it's dependency
            //that's why check of 1 is at the begining, so it will come out
            if(hasCycle(preq, list, state)){
                return true;
            }
        }
        //course completed, visited
        state[course]=2;
        return false;
    }
}
