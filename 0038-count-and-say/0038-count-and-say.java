class Solution {
    public String countAndSay(int n) {
           if(n<=0)
            return "-1";
        String ans = "1";
        for(int i=1 ; i<n ; i++)
            ans  = helper(ans);
        return ans;
    }
    String helper(String ans){
        StringBuilder builder = new StringBuilder();
        int i=0;
        while(i<ans.length()){
            char temp = ans.charAt(i);
            int cnt =0;
            while(i<ans.length() && ans.charAt(i)==temp){
                    i++;
                    cnt++;
            }
            builder.append(String.valueOf(cnt));
            builder.append(temp);
        }
        return builder.toString();
    }

}