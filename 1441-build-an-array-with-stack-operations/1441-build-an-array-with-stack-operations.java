class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> op = new ArrayList<>();
        int curr = 1;
        for(int i=0; i<target.length ; i++){
            while(curr < target[i]){
                op.add("Push");
                op.add("Pop");
                curr++;
            }
            op.add("Push");
            curr++;

        }
        return op;
    }
}