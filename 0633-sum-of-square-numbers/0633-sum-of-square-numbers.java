class Solution {
    public boolean judgeSquareSum(int c) {
        long l =0 ;
        long r = (long)Math.sqrt(c);
        while(r>=l){
            long curr = l*l + r*r;
            if(curr > c )
                r--;
            else if (curr <  c)
                l++;
            else
                return true;
        }
        return false;
        
        
    }
}