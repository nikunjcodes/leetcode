class Solution {
    public long countOfSubstrings(String word, int k) {
        return helper(k, word) - helper(k + 1, word);
    }

    private long helper(int k, String word) {
        int n = word.length();
        long ans = 0;
        int con = 0;
        int[] freq = new int[26];
        int left = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            char ch = word.charAt(right);
            int idx = ch - 'a';
            if (isVowel(ch)) {
                set.add(ch);
            } else {
                con++;
            }

            freq[idx]++;
            while (con >= k && set.size() == 5) {
                ans += (n - right);
                char c = word.charAt(left);
                int leftIdx = c - 'a';

                if (isVowel(c)) {
                    if (--freq[leftIdx] == 0) { 
                        set.remove(c);
                    }
                } else {
                    con--;
                }

                left++;
            }
        }
        return ans;
    }
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
