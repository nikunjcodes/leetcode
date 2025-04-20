class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer , Integer> map = new HashMap<>();
        int sum=0;
      for(int i : answers){
            if(i==0){
                sum+=1;
                continue;
            }
            if(!map.containsKey(i)){
                map.put(i,0);
                sum+=(i+1);
            }
            else{
                map.put(i , map.get(i)+1);
                if(map.get(i)==i)
                    map.remove(i);
            }
      }
      return sum;
    }
}