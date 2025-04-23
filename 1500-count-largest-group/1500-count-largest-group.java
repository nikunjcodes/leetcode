class Solution {
    public int countLargestGroup(int n) {
        Map<Integer , Integer> hmap = new HashMap<>();
        int ans=0;
        for(int i=1  ; i<=n ; i++){
            int val=i;
            int sum=0;
            while(val >0){
                sum+=val%10;
                val=val/10;
            }
            hmap.put(sum , hmap.getOrDefault(sum,0)+1);
        }
        int max = Collections.max(hmap.values());
        for(int count : hmap.values())
            if(count==max) ans++;
        return ans;
    }
}