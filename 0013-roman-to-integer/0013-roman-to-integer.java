class Solution {
    public int romanToInt(String s) {
              int ans=0;
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='I'){
                if((i!=s.length()-1)&&(s.charAt(i+1)=='V' || s.charAt(i+1)=='X'))
                        ans-=1;
                        else 
                        ans+=1;

            }
            else if(s.charAt(i)=='V')
                    ans+=5;
            else if (s.charAt(i)=='X'){
                if((i!=s.length()-1)&&(s.charAt(i+1)=='L' || s.charAt(i+1)=='C'))
                        ans-=10;
                        else 
                        ans+=10;                

            
            }
            else if (s.charAt(i)=='L')
                ans+=50;
            else if (s.charAt(i)=='C'){
                 if((i!=s.length()-1)&&(s.charAt(i+1)=='D' || s.charAt(i+1)=='M'))
                        ans-=100;
                        else 
                        ans+=100;
             
            }
            else if (s.charAt(i)=='D')
                    ans+=500;
                    
            else 
                ans+=1000;
        }
        return ans;
    
    }
}