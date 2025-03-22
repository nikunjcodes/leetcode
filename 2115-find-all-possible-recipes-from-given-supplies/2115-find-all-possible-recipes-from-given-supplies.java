class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,LinkedList<String>> map = new HashMap<>();
        HashMap<String,Integer> indegree = new HashMap<>();
        for(int i = 0;i<recipes.length;i++){
            for(int j = 0;j<ingredients.get(i).size();j++){
                String s = ingredients.get(i).get(j);
                if (map.containsKey(s)) {
                    LinkedList<String> a = map.get(s);
                    a.add(recipes[i]);
                    map.put(s,a);
                }
                else{
                    LinkedList<String> a  = new LinkedList<>();
                    a.add(recipes[i]);
                    map.put(s,a);
                }
                indegree.put(recipes[i],indegree.getOrDefault(recipes[i],0)+1);
                
            }
        }
        Queue<String> q = new LinkedList<>();
        List<String> res = new LinkedList<>();
        for(String str : supplies){
            q.add(str);
        }
        while(!q.isEmpty()){
            String cur = q.poll();
            if(!map.containsKey(cur)) continue;
            LinkedList<String> r = map.get(cur);
            for(int i = 0;i<r.size();i++){
                indegree.put(r.get(i),indegree.get(r.get(i))-1);
                if(indegree.get(r.get(i))==0) {
                    res.add(r.get(i));
                    if(map.containsKey(r.get(i))) q.offer(r.get(i));
                }
                
            }
            
        }
        return res;
    }
}