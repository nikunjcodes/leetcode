class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        boolean[][] conn = new boolean[numCourses][numCourses];
        for(int[] pre : prerequisites){
            conn[pre[0]][pre[1]] = true;
        }
        for(int i=0 ; i<numCourses ; i++){
            for(int j=0 ; j<numCourses ; j++){
                for(int k=0 ; k<numCourses ; k++){
                    conn[j][k] = conn[j][k] || conn[j][i] && conn[i][k];
                }
            }
        }
        for(int[] q : queries)
            ans.add(conn[q[0]][q[1]]);
        return ans;
    }
}