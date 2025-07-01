class Solution {
    public int possibleStringCount(String word) {
        int ans=1;
        int i=0;
        char[] arr = word.toCharArray();
        while(i<arr.length ){
            if( i >0 && arr[i]==arr[i-1]){
                ans++;
                i++;
                continue;
            }
            i++;
            
        }
        return ans;
    }
}