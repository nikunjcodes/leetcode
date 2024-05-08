class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int emp=0;
        int i =0;
        while(i<hours.length){
            if(hours[i]>=target)
                emp++;
            i++;
        }
    return(emp);
    }
}