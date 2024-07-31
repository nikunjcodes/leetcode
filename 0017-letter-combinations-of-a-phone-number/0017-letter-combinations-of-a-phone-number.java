class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty())
                return ans;
        String[] map = {"abc", "def", "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};
        char[] curr = new char[digits.length()];
        helper(ans,0,map,digits,curr);
        return ans;
    }
    static void helper(List<String>ans , int idx , String[] map , String digits,char[] curr){
        if(idx == digits.length()){
            ans.add(new String(curr));
            return;
        }
        char digit = digits.charAt(idx);
        String letters = map[digit-'0'-2];
        for(char letter: letters.toCharArray()){
            curr[idx] = letter;
            helper(ans,idx+1 , map,digits,curr);
        }
            
    }
}