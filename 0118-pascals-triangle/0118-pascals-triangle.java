class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =1 ; i<=n ; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=1 ; j<=i  ; j++){
                temp.add(nCr(i-1,j-1));
            }
            ans.add(temp);
        }
        return ans;
    }
    public static int nCr(int n, int r){
        long res=1;
        for(int i=0 ; i<r ; i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return (int)res;
    }
}