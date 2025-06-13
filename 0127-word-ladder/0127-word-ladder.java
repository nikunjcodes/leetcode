class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int ans=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                String word = q.poll();
                for(int j=0 ;j <endWord.length();  j++){
                    for(char letter ='a' ; letter<='z' ; letter++){
                        StringBuilder newWord = new StringBuilder(word);
                        newWord.setCharAt(j ,letter);
                        if(set.contains(newWord.toString())){
                            if(newWord.toString().equals(endWord)) return ans+1;
                            set.remove(newWord.toString());
                            q.offer(newWord.toString());
                        }
                    }
                }

            }
                    ans++;

        }
        return 0;
        
    }
}