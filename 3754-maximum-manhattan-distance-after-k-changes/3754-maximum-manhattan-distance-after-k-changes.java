class Solution {
    public int maxDistance(String s, int k) {
        int ans=0;
        int n=0;
        int south=0;
        int w=0;
        int e=0;
        for(int i=0 ; i<s.length() ; i++){
            char ch =  s.charAt(i);
            if(ch=='N')
                n++;
            else if(ch=='E')
                e++;
            else if(ch=='W')
                w++;
            else
                south++;
        
        int x=  Math.abs(n-south);
        int y= Math.abs(e-w);
        int maxD = x+y;
        int dis = maxD  + Math.min(2*k , i+1-maxD);
        ans =Math.max(ans ,dis);
    }
    return ans;
    }
}