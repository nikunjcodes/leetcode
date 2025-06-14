
import java.math.BigInteger;

class Solution {

    void buildRemaining(int[] a, long total, long curTotal, long k, StringBuilder sb) {
        if(total == 0 || k == 0) return;
        long sum = 0;
        long cur = 0;
        for(int i = 0; i < 26; i++) {
            if(a[i] == 0) continue;
            cur = curTotal * a[i] / total;
            if(sum + cur >= k) {
                sb.append((char)(i + 'a'));
                a[i]--;
                buildRemaining(a, total-1, cur, k - sum, sb);
            }
            sum += cur;
        }
    }

    StringBuilder count(int[] a, int k) {
        BigInteger res = BigInteger.valueOf(1);
        long total = 1;
        StringBuilder ret = new StringBuilder();
        for(int i = 25; i >= 0; i--) {
            for(int j = 0; j < a[i]; j++) {
                res = res.multiply(BigInteger.valueOf(total++)).divide(BigInteger.valueOf(j + 1));
                if(res.compareTo(BigInteger.valueOf(k)) >= 0) {
                    total = 0;
                    for(int L = 0; L < i; L++) {
                        for(int M = 0; M < a[L]; M++) ret.append((char)('a' + L));
                        a[L] = 0;
                    }
                    for(int L = j + 1; L < a[i]; L++) {
                        ret.append((char)('a' + i));
                    }
                    a[i] = j + 1;
                    for(int t : a) total += t;
                    buildRemaining(a, total, res.longValue(), k, ret);
                    return ret;
                }
            }
        }
        return ret;
    }

    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for(int i = 0; i < 26; i++) cnt[i] /= 2;

        StringBuilder sb = count(cnt, k);

        int len = sb.length();
        if(len == s.length() / 2 && (s.length() & 1) == 1) sb.append(s.charAt(s.length()/2));
        while(len > 0) {
            sb.append(sb.charAt(--len));
        }
        return sb.toString();
    }
}