import java.util.Arrays;

class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        char[] vow = new char[s.length()];
        int cnt = 0;
        for (char c : arr) {
            if (isVowel(c)) {
                vow[cnt++] = c;
            }
        }
        Arrays.sort(vow, 0, cnt);
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = vow[j++];
            }
        }
        return new String(arr);
    }

    static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
