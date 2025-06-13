import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> results = new ArrayList<>();
        if (!dict.contains(endWord)) return results;

        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, dict, parents, distance);

        if (!distance.containsKey(endWord)) return results; 

        LinkedList<String> path = new LinkedList<>();
        dfs(endWord, beginWord, parents, path, results);
        return results;
    }

    private void bfs(String beginWord, String endWord, Set<String> dict,
                     Map<String, List<String>> parents, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int currDist = distance.get(word);

            for (String neighbor : getNeighbors(word, dict)) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currDist + 1);
                    queue.offer(neighbor);
                    parents.put(neighbor, new ArrayList<>());
                    parents.get(neighbor).add(word);
                } else if (distance.get(neighbor) == currDist + 1) {
                    parents.get(neighbor).add(word);
                }
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (dict.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

    private void dfs(String current, String beginWord, Map<String, List<String>> parents,
                     LinkedList<String> path, List<List<String>> results) {
        path.addFirst(current);
        if (current.equals(beginWord)) {
            results.add(new ArrayList<>(path));
        } else {
            if (parents.containsKey(current)) {
                for (String p : parents.get(current)) {
                    dfs(p, beginWord, parents, path, results);
                }
            }
        }
        path.removeFirst();
    }
}
