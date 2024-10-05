class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for(int i=0 ; i<s1.length() ; i++){
            count[s1.charAt(i)-'a']++;
        }
        for(int i=0 ; i<s2.length() ; i++){
            count[s2.charAt(i)-'a']--;
            if(i-s1.length() >=0)
                count[s2.charAt(i-s1.length())-'a']++;
            if(flag(count))
                return true;
        }
        return false;
    }
    static boolean flag(int[] count){
        for(int i=0 ; i<26 ; i++){
            if(count[i]!=0)
                return false;
        }
        return true;
    }
}