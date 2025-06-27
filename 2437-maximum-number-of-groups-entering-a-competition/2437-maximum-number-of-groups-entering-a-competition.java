class Solution {
    public int maximumGroups(int[] grades) {
        int last =0;
        int n = grades.length;
        int ans=0;
        while(n > last){
            last++;
            ans++;
            n-=last;           
        }
        return ans;
    }
}