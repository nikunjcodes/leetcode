class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        for(int i=Math.max(2,left) ; i<=right ;i++){
            if(helper(i))
                primes.add(i);
        
        }
        if(primes.size()<2)
            return new int[] {-1,-1};
        int min = Integer.MAX_VALUE;
        int[] result = new int[]{-1,-1};
        for(int i=1 ; i<primes.size();i++){
            int diff = primes.get(i)-primes.get(i-1);
            if(diff<min){
                min = diff;
                result[0] = primes.get(i-1);
                result[1] = primes.get(i);
            }
        }   
            return result;
     
    }
    private boolean helper(int n){
        if(n<=1)
            return false;
        if(n<=3)
            return true;
        if(n%2==0 || n%3==0)
            return false;
        for(int i=5 ; i*i<=n ; i+=6){
            if(n%i==0 || n%(i+2)==0)
                return false;
        }
        return true;
    }
}