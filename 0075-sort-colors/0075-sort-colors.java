class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one = 0;
        int two = 0;
        for(int num : nums){
            if(num==0){
                zero++;
            }
            else if (num==1)
                one++;
            else
                two++;
        }
        for(int i=0 ; i<zero ; i++)
            nums[i]=0;
        for(int i=zero ; i<zero+one ; i++){
            nums[i] =1;
        }
        for(int i= zero+one ; i<zero+one+two ; i++)
            nums[i]=2;
        
    }
}