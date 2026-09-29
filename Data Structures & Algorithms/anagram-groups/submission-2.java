class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //a simple map with key as string(our sorted), and value as sub list
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s:strs){
            //convert to array so we can sort
            char[] sArray=s.toCharArray();
            //sorting
            Arrays.sort(sArray);
            String sortedString = new String(sArray);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
