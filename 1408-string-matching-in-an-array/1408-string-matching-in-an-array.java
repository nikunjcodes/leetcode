import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        
        List<String> ans = new ArrayList<>();
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break; 
                }
            }
        }
        
        return ans;
    }
}
