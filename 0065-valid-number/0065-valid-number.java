class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        s=s.toLowerCase();
        boolean dec = false;
        boolean e = false;
        boolean num = false;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                num = true;
            } else if(s.charAt(i) == '.') {
                if(e || dec)
                    return false;
                dec = true;
            } else if(s.charAt(i) == 'e') {
                if(e || !num)
                    return false;
                num = false;
                e = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            } else
                return false;
        }
        return num;
    }
}