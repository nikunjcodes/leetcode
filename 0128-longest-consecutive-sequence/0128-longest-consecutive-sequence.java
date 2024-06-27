import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        if(nums.length==0)
                return 0;
        else{
            Set<Integer> set = new HashSet<>();
             ans=1;
            for(int i=0 ; i<nums.length ; i++)
                    set.add(nums[i]);
            for(int it: set){
                if(!set.contains(it -1 )){
                    int cnt =1;
                    int x=it;
                    while(set.contains(x+1)){
                        x++;
                        cnt++;
                    }
                    ans = Math.max(cnt,ans);
                }
            }
        }
        return ans;
    }
}