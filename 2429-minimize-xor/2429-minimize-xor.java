class Solution {
    public int minimizeXor(int num1, int num2) {
        int n1 = Integer.bitCount(num1);
        int n2 = Integer.bitCount(num2);
        int res = num1;
        for(int i=0 ; i<32 ; i++){
            if(n1>n2 && ((1<<i) & num1)>0){
                res ^= 1<<i;
                n1--;
            }
            if(n1<n2 && ((1<<i) & num1)==0){
                res^=1<<i;
                n1++;
            }
        }
        return res;

    }
}