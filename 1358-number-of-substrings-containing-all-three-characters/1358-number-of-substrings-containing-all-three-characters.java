class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[3]; 
        int res=0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;

            while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                res += s.length() - i;
                hash[s.charAt(left++) - 'a']--;
            }
        }
        return res;
    }
}