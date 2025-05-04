class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] hmap = new int[100];
        for (int[] d : dominoes) 
            if (d[0] > d[1]) hmap[d[0] * 10 + d[1]]++;
            else hmap[d[1] * 10 + d[0]]++;
        
        int cnt = 0;
        for (int freq : hmap)
            cnt += (freq - 1) * freq / 2;
        
        return cnt;
    }
}