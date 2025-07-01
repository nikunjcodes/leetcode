class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x , int y){
            this.x= x;
            this.y=y;
        } 
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public boolean canMeasureWater(int x, int y, int target) {
        Set<Pair> set = new HashSet<>();
        Stack<Pair> q = new Stack<>();
        q.add(new Pair(0 , 0));
        while(!q.isEmpty()){
            Pair p = q.pop();   
            if(set.contains(p))
                continue;
            if(p.x + p.y == target)
                return true;
            set.add(p);
            q.push(new Pair(0 , p.y));
            q.push(new Pair(p.x , 0));
            q.push(new Pair(x , p.y));
            q.push(new Pair(p.x , y));
            q.push(new Pair(Math.max(0 , p.x-(y - p.y)), Math.min(p.x + p.y , y)));
            q.push(new Pair(Math.min(p.x + p.y, x),Math.max(0, p.y - (x - p.x))));
        }
        return false;
    }
}