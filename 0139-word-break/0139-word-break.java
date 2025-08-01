class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
            return false;
        Set<Integer> set = new HashSet<Integer>();
        return helper(s , 0 ,set, wordDict);
    }
    boolean helper(String s , int idx , Set<Integer>set , List<String> wordDict){
        if(idx==s.length())
            return true;
        for(int i= idx+1 ; i<=s.length() ; i++){
            if(set.contains(i))
                continue;
            if(wordDict.contains(s.substring(idx, i))){
                if(helper(s , i , set ,wordDict))
                    return true;
                set.add(i);
            }
        }
        return false;
    }

}