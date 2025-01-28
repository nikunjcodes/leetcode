class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] flag = new int[100001];
        for(int i=0  ; i<matches.length ; i++){
            int win = matches[i][0];
            int los = matches[i][1];
            if(flag[los]==-1)
                flag[los]=1;
            else
                flag[los]++;
            if(flag[win]==0)
                flag[win] = -1;
        }
            List<Integer> zero = new ArrayList<>();
            List<Integer> one = new ArrayList<>();
            for(int i=0 ; i<flag.length ; i++){
                if(flag[i]==-1)
                    zero.add(i);
                else if (flag[i]==1)
                    one.add(i);
            }
        
        ans.add(zero);
        ans.add(one);
        return ans;
    }
}