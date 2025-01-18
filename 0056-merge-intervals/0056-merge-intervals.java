class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1)
            return intervals;
        Arrays.sort(intervals , (a,b)->Integer.compare(a[0] , b[0]));
        List<int[]>ans = new ArrayList<>();
        int[] temp = intervals[0];
        ans.add(temp);
        for(int[] interval : intervals){
            if(interval[0] <= temp[1])
                temp[1] = Math.max(temp[1] , interval[1]);
            else{
                temp = interval;
                ans.add(temp);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}