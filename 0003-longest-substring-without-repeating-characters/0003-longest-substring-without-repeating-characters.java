class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                l  = Math.max(map.get(s.charAt(r))+1 , l);
                
            }
            map.put(s.charAt(r),r);
            ans = Math.max(ans,  r-l+1);
            r ++;
        }
        return ans;
   
    }
}