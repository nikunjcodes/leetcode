class Solution {
            int ans =0;
    public int numTilePossibilities(String tiles) {
        char[] tile = tiles.toCharArray();
        boolean[] visited = new boolean[tile.length];
        Arrays.sort(tile);
        helper(tile , visited);
        return ans-1;
    }
    void helper(char[] tile , boolean[] visited){
        ans++;
        for(int i=0 ; i<tile.length ; i++){
            if(visited[i] || (i>0 && tile[i] == tile[i-1] && !visited[i-1]))
                continue;
            visited[i] = true;
            helper(tile , visited);
            visited[i] = false;
        }
    }

}