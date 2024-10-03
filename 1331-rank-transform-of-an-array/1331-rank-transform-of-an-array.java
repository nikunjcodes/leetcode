class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(temp);
        int k=1 ; 
        for(int i=0 ; i<temp.length ; i++){
            if(!map.containsKey(temp[i]))
                map.put(temp[i],k++);
        }
        int[] ans = new int[arr.length];
        for(int i=0 ; i<arr.length ; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}