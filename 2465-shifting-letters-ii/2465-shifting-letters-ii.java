class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] psum = new int[n+1];
        for(int[] shift : shifts){
            int st = shift[0] , end = shift[1] , dir = shift[2];
            if(dir==0)
                psum[st] +=-1;
            else
                psum[st] +=1;
            if(end+1 < n){
                if(dir==0)
                    psum[end+1] -=-1;
                else
                    psum[end+1] -= 1;

            }
        }
        int shiftt =0 ;
        for(int i=0 ; i<n ; i++){
            shiftt += psum[i];
            psum[i] = shiftt;
        }
        StringBuilder res = new StringBuilder(s);
        for(int i=0 ; i<n ; i++){
            int sht = (psum[i]%26 + 26)%26;
            res.setCharAt(i,(char)('a'+(s.charAt(i)-'a' + sht)%26));
        }
        return res.toString();
    }
}