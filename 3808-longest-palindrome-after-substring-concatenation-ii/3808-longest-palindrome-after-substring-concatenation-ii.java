class Solution {
    public int longestPalindrome(String s, String t) {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(t).reverse();
        String s1 = sb.toString();
        int[] max1 = new int[s.length()];
        int[] max2 = new int[s1.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    max1[i] = j - i + 1;
                    if (max1[i] > max) {
                        max = max1[i];
                    }
                }
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {
                if (isPalindrome(s1.substring(i, j + 1))) {
                    max2[i] = j - i + 1;
                    if (max2[i] > max) {
                                                max = max2[i];
                    }
                }
            }
        }
        int[][] dp = new int[s.length() + 1][s1.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s.charAt(i) == s1.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    int r1 = 0;
                    if (i < s.length() - 1) {
                        r1 = max1[i + 1];
                    }
                    int r2 = 0;
                    if (j < s1.length() - 1) {
                        r2 = max2[j + 1];
                    }
                    int cur = 2 * dp[i + 1][j + 1] + Math.max(r1, r2);
                    if (cur > max) {
                        max = cur;
                    }
                }
            }
        }

        return max;
    }

    public boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}