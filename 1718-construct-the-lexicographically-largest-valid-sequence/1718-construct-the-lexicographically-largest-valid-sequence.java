    class Solution {
        public int[] constructDistancedSequence(int n) {
            int[] ans = new int[n*2-1];
            boolean[] flag = new boolean[n+1];
            helper(0,ans,flag, n);
            return ans;
        }
        boolean helper(int idx , int[] ans ,  boolean[] flag , int n){
            if(idx==ans.length)
                return true;
            if(ans[idx]!=0)
                return helper(idx+1 , ans , flag , n);
            else{
                for(int i=n ; i>=1 ; i--){
                    if(flag[i])
                        continue;
                    flag[i] = true;
                    ans[idx] = i;
                    if(i==1){
                        if(helper(idx+1 , ans , flag , n)) 
                            return true;
                }
                else if (idx+i  < ans.length && ans[idx+i] ==0){
                    ans[idx+i] =i;
                    if(helper(idx+1 , ans ,flag , n))
                        return true;
                    ans[idx+i] =0;
                }
                ans[idx]=0;
                flag[i] = false;
                }
            }
            return false;
        }
    }