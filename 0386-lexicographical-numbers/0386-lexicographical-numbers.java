class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> li = new ArrayList<>();
        helper(n,1,li);
        return li;
    }
    public void helper(int n, int t , List<Integer> li){
        if(t>n)
            return;
        li.add(t);
        helper(n,t*10,li);
        if(t%10!=9)
            helper(n,t+1,li); 
        
    }
}