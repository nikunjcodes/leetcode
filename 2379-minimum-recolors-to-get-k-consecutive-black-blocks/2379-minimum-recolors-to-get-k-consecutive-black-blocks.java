class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans=Integer.MAX_VALUE;
        for(int i=0 ; i<=blocks.length() - k ; i++){
                        int temp=0;
            if(blocks.charAt(i)=='W')
                temp=1;
            for(int j=1 ; j<k ; j++){
                if(blocks.charAt(i+j)=='W')
                    temp++;
            }
            ans = Math.min(temp,ans);
        }
        return ans;
    }
}