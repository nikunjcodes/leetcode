class Solution {
    public char kthCharacter(int k) {
        String temp = "a";
        // 97-122
        while(temp.length() <=k){
            int size=  temp.length();
            for(int i=0  ; i<size ; i++){
                int c = (temp.charAt(i) -'a' + 1 )%26;
                char next = (char) ('a' + c);
                temp+=next;
            }
        }
        return temp.charAt(k-1);
    }
}