class Solution {
    Map<String , Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length()!=s2.length())
            return false;
        if(map.containsKey(s1+s2))
            return map.get(s1+s2);
        int[] a=  new int[26];
        int[] b = new int[26];
        for(int i=0 ; i<s1.length() ; i++){
            a[s1.charAt(i)-'a']++;
            b[s2.charAt(i)-'a']++;
        }
        if(!Arrays.equals(a,b))
            return false;
        for(int i=1 ; i<s1.length() ; i++){
            if(isScramble(s1.substring(i) , s2.substring(i)) && isScramble(s1.substring(0,i) , s2.substring(0,i))){
                map.put(s1+s2 , true);
                return true;
            }
            if(isScramble(s1.substring(i) , s2.substring(0 , s2.length()-i)) && isScramble(s1.substring(0,i) , s2.substring(s2.length()-i))){
                map.put(s1+s2 , true);
                return true;
            }

        }
        map.put(s1+s2,  false);
        return false;
    }
}