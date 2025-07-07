class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(x1,x2) -> Integer.compare(x1[0],x2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0,n = events.length ,res = 0;
        int day = 1;
        while(i<n || !pq.isEmpty()){
            while(i<n && events[i][0]== day){
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
            
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
            day++;
        }
        return res;
    }
}