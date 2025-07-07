class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)
            return 1;
        PriorityQueue<Long> pq =new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        pq.offer(1L);
        seen.add(1L);
        long ugly =1;
        for(int i=1 ; i<=n ; i++){
            ugly = pq.poll();
            if(seen.add(ugly*2))
                pq.offer(ugly*2);
            if(seen.add(ugly*3))
                pq.offer(ugly*3);
            if(seen.add(ugly*5))
                pq.offer(ugly*5);
        }
        return (int) ugly;

    }
}