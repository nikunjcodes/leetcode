class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1 ; i<=numRows ; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=1 ; j<=i ; j++){
                temp.add(nCr(i-1 , j-1));
            }
            ans.add(temp);
        }
        return ans;

    }
    int nCr(int n, int r){
        long ans=1;
        for(int i=0 ; i<r ; i++){
            ans=ans*(n-i);
            ans = ans/(i+1);
        }
        return (int) ans;
    }
}