class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String temp = s;
        int i=0;
        while(i<temp.length() && temp.charAt(i)=='9')
            i++;
        if(i<temp.length()){
            temp=temp.replace(temp.charAt(i), '9');
        }
        s = s.replace(s.charAt(0) ,'0');
        return Integer.parseInt(temp) - Integer.parseInt(s);
    }
}