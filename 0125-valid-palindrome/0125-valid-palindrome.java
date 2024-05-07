class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        String check="";
        for(int i=0 ; i<s.length() ; i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
            check+=s.charAt(i);
        }
        int flag=1;

        
        for(int i=0 ; i<check.length()/2; i++){
            if(check.charAt(i)==check.charAt(check.length()-i-1))
                flag=1;
            else{
                flag=0;
                break;
        }
        }
        if(flag==1)
        return true;
        else
            return false;
    }
}