class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) return false;

        int open = 0, unlock = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                unlock++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else if (unlock > 0) {
                    unlock--;
                } else {
                    return false;
                }
            }
        }

        open = 0;
        unlock = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                unlock++;
            } else if (s.charAt(i) == ')') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else if (unlock > 0) {
                    unlock--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
