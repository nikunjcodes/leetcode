class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)
            return false;
        boolean vowel=false;
        boolean con =false;;
        boolean number= false;
        String vowels = "aeiouAEIOU";
        for(char ch  : word.toCharArray()){
            if(ch >='0' && ch<='9')
                number = true;
            else if( (ch >='a' && ch<='z') || (ch >='A' && ch<='Z')){
                if(vowels.contains(""+ch))
                    vowel=true;
                else
                    con = true;
            }
            else
                return false;
        }
        return  vowel && con;
    }
}