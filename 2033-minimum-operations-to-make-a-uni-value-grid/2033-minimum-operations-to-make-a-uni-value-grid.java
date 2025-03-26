class Solution {
    public int minOperations(int[][] grid, int x) {
       List<Integer> elements = new ArrayList<>();
       for(int[] row : grid){
        for(int val : row)
            elements.add(val);
       }
       Collections.sort(elements);
       for(int elem : elements){
        if(Math.abs(elem - elements.get(0))%x != 0)
            return -1;
       }
       int mid = elements.get(elements.size()/2);
       int ans=0;
       for(int element : elements)
            ans += Math.abs(element - mid)/x;
        return ans;
    }
}