class Solution {
    public int lastRemaining(int n) {
        int head=1;
        int step=1;
        boolean flag = true;
        while(n>1){
            if(flag || n%2==1){
                head = head+step;
            }
            step =  step*2;
            n=n/2;
            flag = !flag;
        }
        return head;
    }
}