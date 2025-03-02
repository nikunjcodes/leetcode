class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer , Integer> hmap = new HashMap<>();
        for(int[] num : nums1){
            hmap.put(num[0] , num[1]);
        }
        for(int[] num : nums2){
            if(hmap.containsKey(num[0]))
                hmap.put(num[0] , hmap.get(num[0])+num[1]);
            else
                hmap.put(num[0],num[1]);
        }
        int[][] ans = new int[hmap.size()][2];
        int i=0;
        for(int key : hmap.keySet())
            ans[i++] = new int[] {key ,hmap.get(key)};
        Arrays.sort(ans , (a,b) -> a[0] - b[0]);
        return ans;
    }
}