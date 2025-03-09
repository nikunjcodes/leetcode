class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans=0;
        int l=0;
        for(int i=0 ; i<colors.length+k-1 ; i++){
            if(i>0 && colors[i%colors.length]== colors[(i-1)%colors.length])
                l=i;
            if(i-l+1>=k)
                ans++;
        }
        return ans;
    }
}