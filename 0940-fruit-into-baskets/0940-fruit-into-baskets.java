class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int n = fruits.length;
        int max=0;
        Map<Integer , Integer> map = new HashMap<>();
        for(int j=0 ; j<n ; j++){
            map.put(fruits[j] , j);
            if(map.size()>2){
                int min = Collections.min(map.values());
                map.remove(fruits[min]);
                i= min+1;
            }
            max = Math.max(max , j-i+1);
        }
        return max;
    }
}