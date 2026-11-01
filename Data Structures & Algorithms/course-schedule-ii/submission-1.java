class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        //empty list for each courses
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        //add depdency
        for(int[] preq:prerequisites){
            list.get(preq[0]).add(preq[1]);
        }
        int[] state = new int[numCourses];
        //to store the order of courses for result
        List<Integer> order = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            //if found cycles, means not possible, return empty array
            if(hasCycle(i, list, state, order)){
                return new int[0];
            }
        }
        //conver the order in result to return the output format
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=order.get(i);
        }
        return result;
    }

    private boolean hasCycle(int course, List<List<Integer>> list, int[] state, List<Integer>
    order){
        //if cycle return true, if done, return false
        if(state[course]==1){
            return true;
        }
        if(state[course]==2){
            return false;
        }
        state[course]=1;
        //loop all preq
        for(int freq:list.get(course)){
            if(hasCycle(freq, list, state, order)){
                return true;
            }
        }
        //mark course as complete and add in order for output
        state[course]=2;
        order.add(course);
        return false;
    }
}
