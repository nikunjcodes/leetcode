class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs,Comparator.comparing(s->s.length()));
        int len = strs[0].length();
        int len2 = strs.length;
        String common="";
        for(int i=0 ; i<len ; i++){
            int flag=0;
            for(int j=0 ; j<len2 ; j++){
                if(strs[j].charAt(i)==strs[0].charAt(i))
                    flag++;
                else
                    break;
            }
            if(flag==len2)
                common+=strs[0].charAt(i);
            else
                break;
        }
        return common;

    }
}