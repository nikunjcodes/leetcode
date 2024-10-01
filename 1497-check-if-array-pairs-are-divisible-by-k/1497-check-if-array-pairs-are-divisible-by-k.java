class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for(int num : arr){
            num = num%k;
            if(num<0)
                num+=k;
            count[num]++;
        }
        if(count[0]%2!=0)
            return false;
        for(int i=1 ; i<=k/2 ; i++){
            if(count[i]!=count[k-i])
                return false;
            }
        
                    return true;

    }
}