class Solution {
    public int maxConsecutiveAnswers(String answer, int k) {
        int trueCnt = 0;
        int falseCnt =0;
        int ans=0;
        for(int i=0, j=0 ; j<answer.length() ; j++){
                if(answer.charAt(j)=='T')
                    trueCnt++;
                else
                    falseCnt++;
                while(Math.min(trueCnt , falseCnt ) >k){
                    if(answer.charAt(i++)=='T')
                        trueCnt--;
                    else
                        falseCnt--;
                }
                ans = Math.max(ans , j-i+1);

        }
        return ans;
    }
}