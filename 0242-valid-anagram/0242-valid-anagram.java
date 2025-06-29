class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] arr = new int[27];
        for(int i=0 ; i<s.length()  ; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i=0 ; i<27 ; i++){
            if(arr[i]!=0)
                return false;
        }
        return true;

    }
}