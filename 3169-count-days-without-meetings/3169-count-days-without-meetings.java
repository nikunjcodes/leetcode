class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings , (a,b) -> Integer.compare(a[0] , b[0]));
        int end=0;
        int count =0;
        for(int[] m : meetings){
            int start = m[0];
            int endd = m[1];
            if(end < start )
                count += start- end-  1;
            end = Math.max(endd , end);
        }
        count += days - end;
        return count;
    }
}