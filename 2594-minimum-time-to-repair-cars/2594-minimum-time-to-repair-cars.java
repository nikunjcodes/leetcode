class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left=1,right = 1L*ranks[0]*cars*cars;
        while(left < right){
            long mid = (left+right)/2;
            long temp=0;
            for(int rank : ranks){
                temp+=(long)(Math.sqrt(1.0*mid/rank));
            }
            if(temp<cars)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}