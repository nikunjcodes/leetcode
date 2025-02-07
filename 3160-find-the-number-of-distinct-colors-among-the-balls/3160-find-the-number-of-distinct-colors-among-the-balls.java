class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Map<Integer , Integer> colorMap = new HashMap<>();
        Map<Integer , Integer> ballMap = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(ballMap.containsKey(ball)){
                int prev = ballMap.get(ball);
                colorMap.put(prev , colorMap.get(prev)-1);
                if(colorMap.get(prev)==0)
                    colorMap.remove(prev);
                }
                ballMap.put(ball , color);
                colorMap.put(color , colorMap.getOrDefault(color,0)+1);
                ans[i] = colorMap.size();
            }
            return ans;
        }
    }
