class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
       HashMap<String , List<String>> hmap = new HashMap<>();
       for(String str : strs){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String sorted = String.valueOf(arr);
        if(hmap.containsKey(sorted))
            hmap.get(sorted).add(str);
        else{
            List<String> temp = new ArrayList<String>();
            temp.add(str);
            hmap.put(sorted ,temp );
        }
       }
       for (List<String> value : hmap.values()) {
        ans.add(value);
            } 
            return ans;
    }
}