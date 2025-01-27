class Solution {
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0)
            return new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        helper(s,new ArrayList<>() , ans);
        return ans;
    }
    void helper(String s, List<String> temp , List<List<String>> ans){
        if(s==null || s.length() ==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=1 ; i<=s.length() ; i++){
            String str = s.substring(0,i);
            if(!isPalindrome(str))
                continue;
            temp.add(str);
            helper(s.substring(i,s.length()) , temp , ans);
            temp.remove(temp.size()-1);
        }
        return;
    }
    boolean isPalindrome(String s ){
        int left =0 , right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}