class Solution {
    public int longestPalindrome(String[] words) {
        int ans=0;
        int sym=0;
        HashMap<String , Integer> map = new HashMap<>();

        for(String word : words){
                map.put(word , map.getOrDefault(word , 0)+1);
        
        }
        for(String word : map.keySet()){
            int freq = map.get(word);
            if(freq==0)
                continue;
            String rev = new StringBuilder(word).reverse().toString();
            if(word.equals(rev)){
                ans+=(freq/2)*4;
                if(freq%2==1)
                    sym=1;
            }
            else if (map.containsKey(rev)){
                int pairs = Math.min(freq , map.get(rev));
                ans+=pairs*4;
                map.put(rev , 0);
            }
            map.put(word , 0);
        }
        if(sym==1)
            ans+=2;
        return ans;
    }
}