class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String acr = "";
        for(String str : words){
            acr+=str.charAt(0);
        }
        if(acr.equals(s))
            return true;
        else
            return false;
    }
}