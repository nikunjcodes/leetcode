class Solution {
    public String getHappyString(int n, int k) {
        char[] res = new char[n+1];
        Arrays.fill(res,'_');
        char[] latters = "abc".toCharArray();
        int min_k = 0;
        int max_k = 0;
        for (int pos = 1; pos<=n; pos++){
            for(int ch = 0; ch<=2; ch++){
                if( latters[ch] != res[pos-1] ){
                    min_k = max_k + 1;
                    max_k += Math.pow(2,n-pos);

                    if (min_k <= k && k <= max_k){
                        max_k = min_k - 1;
                        res[pos] = latters[ch];
                        break;
                    }
                }
            }

            if (res[pos] == '_') { return ""; }
        }
        return new String(res).substring(1);      
    }
}