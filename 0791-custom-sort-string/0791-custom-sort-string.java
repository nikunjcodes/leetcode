class Solution {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray())
            arr[c-'a'] ++;
        StringBuilder sb  =new StringBuilder(); 
        for(char c : order.toCharArray()){
            while(arr[c-'a']-- > 0)
                sb.append(c);
        }
        for(char i='a' ; i <='z' ; i++){
            while(arr[i-'a']-->0)
                sb.append(i);
        }
        return sb.toString();
    }
}