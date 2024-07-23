class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        String temp = "";
        helper(n ,ans,temp);
        return ans;
    }
    static void helper(int n , List<String> ans, String temp){
        if(temp.length() == n){
            ans.add(temp);
            return;
        }
        else if (temp ==""){
            helper(n,ans, temp+"0");
            helper(n,ans,temp+"1");
        }
        else{
            char val = temp.charAt(temp.length()-1);
            if(val=='0'){
                temp=temp+"1";
                helper(n,ans,temp);
            }
            else{
                String temp1= temp+"1";
                helper(n,ans,temp1);
                temp = temp+"0";
                helper(n,ans,temp);
            }
        }
    }
}