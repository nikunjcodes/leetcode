class Solution {
    int getDigits(int n ){
        int ans=0;
        while(n>0){
            n = n/10;
            ans++;
        }
        return ans;
    }
    void helper(int num, int n , int k , List<Integer> ans){
        if(getDigits(num)==n){
            ans.add(num);
            return;
        }
        for(int i=0 ; i<10 ; i++){
            if(Math.abs(num%10 -i)==k)
                helper(num*10 + i , n , k , ans);
        }

    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1  ; i<10 ; i++)
            helper(i , n , k , ans);
return ans.stream().mapToInt(i -> i).toArray();
    }
}