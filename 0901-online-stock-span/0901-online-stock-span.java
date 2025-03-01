class Pair{
    int p1;
    int p2;
    public Pair(int p1 ,  int p2){
        this.p1 = p1;
        this.p2 = p2;
    }
}
class StockSpanner {
    Stack<Pair> st = new Stack<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int ans=1;
        while(!st.isEmpty() && st.peek().p1 <=price){
            ans+=st.pop().p2;
        }
        st.push(new Pair(price , ans ));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */