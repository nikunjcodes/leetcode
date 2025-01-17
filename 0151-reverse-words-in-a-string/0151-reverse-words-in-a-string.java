class Solution {
    public String reverseWords(String s) {
         s= s.trim();
        String[] sa = s.split("\\s+");
        String ans="";
        for(int i=sa.length-1 ; i>=0 ; i--){
            if(i!=0)
            ans=ans+sa[i]+" ";
            else
        ans=ans+sa[i];
        }
        return ans;
    }
}