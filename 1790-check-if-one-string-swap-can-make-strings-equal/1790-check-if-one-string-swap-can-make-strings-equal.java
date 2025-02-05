class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        int count=0;
        int[] temp = new int[2];
        for(int i=0 ; i<s1.length() ; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(count==2)
                    return false;
                temp[count] = i;
                count++;
            }
        }
        if(count ==2 && s1.charAt(temp[0]) == s2.charAt(temp[1]) && s1.charAt(temp[1]) == s2.charAt(temp[0]))
            return true;
        return false;
    }
}