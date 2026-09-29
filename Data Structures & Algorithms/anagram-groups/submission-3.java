class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        //traversal all strings in the array of string
        for(String s:strs){
            int[] count = new int[26];//count array for each string
            //convert string into char array for loop
            char[] sArray = s.toCharArray();
            //check in the string for each letter, and store the frequency in count
            for(char c:sArray){
                count[c-'a']++;
            }
        //get the key which is frequency of one string(it will be same for other string if it is anagram)
            String key =  Arrays.toString(count);
            //store key
            map.putIfAbsent(key, new ArrayList<>());
            //add the actual string which we check
            map.get(key).add(s);
        }
        //return just the values
        return new ArrayList<>(map.values());
    }
}
