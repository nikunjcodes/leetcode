class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(a.length()!=b.length()){
                return Integer.compare(a.length() , b.length());
            }
            else
                return a.compareTo(b);
        });
        for(String s : nums){
            pq.add(s);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.poll();
    }
}