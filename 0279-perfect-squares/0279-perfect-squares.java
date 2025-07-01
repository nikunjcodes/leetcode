class Solution {
    public int numSquares(int n) {
        Queue<Integer> q=  new LinkedList<>();
        q.add(n);
        int ans=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                int node = q.poll();
                for(int j=1  ; j*j <=node ; j++){
                    int temp = node - j*j;
                    if(temp==0)
                        return ans;
                    q.add(temp);
                }
            }
            ans++;
        }
        return ans;
    }
}