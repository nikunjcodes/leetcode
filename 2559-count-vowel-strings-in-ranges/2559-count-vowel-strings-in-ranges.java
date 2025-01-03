class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int n = words.length;
        int[] v = new int[n+1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i=0 ; i<n ; i++){
            v[i+1] = v[i];
            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length()-1)))
                v[i+1]++;
        }
        for(int i=0 ; i<queries.length; i++){
            ans[i] = v[queries[i][1]+1] - v[queries[i][0]];
        }
        return ans;
    }
}