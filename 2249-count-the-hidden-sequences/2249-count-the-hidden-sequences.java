class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long low = 0;
        long high = 0;
        long temp=0;
        for(int i=0 ; i<differences.length ; i++){
            temp+=differences[i];
            low  = Math.min(low , temp);
            high  = Math.max(high , temp);
             
        }
        return (int)Math.max(0 , upper-lower - high +low+1);
    }
    }