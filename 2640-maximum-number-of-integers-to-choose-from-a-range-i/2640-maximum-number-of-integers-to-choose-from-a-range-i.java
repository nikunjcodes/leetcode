class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set =  new HashSet<>();
        for(int i=0 ; i<banned.length ;i++){
            if(banned[i] <=n)
                set.add(banned[i]);
        }
        int ans=0;
        int[] arr = new int[n];
        for(int i=0 ; i<arr.length;i++)
            arr[i] = i+1;
        int sum=0;
        for(int i=0 ; i<arr.length ; i++){
            if(!set.contains(arr[i])){
                sum+=arr[i];
                if(sum > maxSum)
                    break;
                else
                    ans++;
            }
        }
        return ans;
    }
}