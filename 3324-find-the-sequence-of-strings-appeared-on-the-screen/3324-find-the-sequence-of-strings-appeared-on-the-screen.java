class Solution {
    public List<String> stringSequence(String target) {
        StringBuilder temp = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for(int i=0 ; i<target.length() ; i++){
            temp.append('a');
            ans.add(temp.toString());
            while(temp.charAt(i)!=target.charAt(i)){
                temp.setCharAt(i, (char)(temp.charAt(i)+1));
                ans.add(temp.toString());
            }
        }
        return ans;
    }
}