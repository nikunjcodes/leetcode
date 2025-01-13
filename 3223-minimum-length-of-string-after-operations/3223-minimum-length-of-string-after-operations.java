class Solution {
    public int minimumLength(String s) {
        int[] arr = new int[26];
        for(char c  : s.toCharArray()){
            arr[c-'a']++;
        }
        int ans = 0;
        for(int i=0 ; i<26 ; i++ ){
            if(arr[i]!=0 && arr[i]%2==1)
                ans+=1;
            else if (arr[i]!=0 && arr[i]%2==0)
                ans+=2;
        }
        return ans;
    }
}