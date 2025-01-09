class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list , new ArrayList<Integer>() , k , 1 ,n);
        return list;

    }
    void helper(List<List<Integer>> ans , List<Integer> temp , int k , int start , int n){
        if(temp.size()>k)
            return;
        if(temp.size()==k && n==0){
            List<Integer> com = new ArrayList<Integer>(temp);
            ans.add(com);
            return;
        }
        for(int i=start; i<=9 ; i++){
            temp.add(i);
            helper(ans , temp , k , i+1 , n-i);
            temp.remove(temp.size()-1);
        }
    }
}