class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        String check="";
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)>=97 && s.charAt(i)<=122 || ((s.charAt(i)>=48)&& s.charAt(i)<=57))
                check+=s.charAt(i);
        }
        int flag=1;
        if(check.length()==1)
            return true;
        
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
        else if(flag==0)
            return false;
        else
            return true;
    }
}