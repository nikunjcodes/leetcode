class ProductOfNumbers {
    List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0)
            prefix = new ArrayList<>();
        else if (num==1)
            prefix.add(num);
        else{
            for(int i=0 ; i<prefix.size() ; i++)
                prefix.set(i,prefix.get(i)*num);
            prefix.add(num);
        }
        
    }
    
    public int getProduct(int k) {
        return ( k>prefix.size() ? 0 : prefix.get(prefix.size()-k));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */