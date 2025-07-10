import java.util.TreeSet;

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        TreeSet<Integer> bars = new TreeSet<>();
        TreeMap<Integer,Set<Integer>> segMap = new TreeMap<>();
        List<Boolean> res = new ArrayList<>();
        bars.add(0);
        bars.add(50001);

        for (int[] query : queries) {
            if (query[0] == 1) {
                int currLoc = query[1];
                bars.add(currLoc);
                int prevLoc = bars.lower(currLoc);
                int nextLoc = bars.higher(currLoc);
                int segLen = nextLoc - prevLoc;
                if (segMap.containsKey(segLen)) {
                    segMap.get(segLen).remove(prevLoc);
                    if (segMap.get(segLen).isEmpty()) {
                        segMap.remove(segLen);
                    }                    
                }
                segMap.computeIfAbsent(currLoc - prevLoc, s -> new HashSet<>()).add(prevLoc);
                segMap.computeIfAbsent(nextLoc - currLoc, s -> new HashSet<>()).add(currLoc);
                
            } else {
                int blockLen = query[2];
                int upperLimit = query[1];
                if (blockLen > upperLimit) {
                    res.add(false);
                    continue;                    
                }

                if (segMap.isEmpty()) {
                    res.add(true);
                    continue;
                }
                Integer ceilingKey = segMap.ceilingKey(blockLen); 
                if (ceilingKey == null) {
                    res.add(false);
                    continue;
                }
                
                Set<Integer> eligibleKeys = segMap.tailMap(ceilingKey).keySet();

                Boolean canPlace = false;
                for (Integer key : eligibleKeys) {
                    Set<Integer> startingLocs = segMap.get(key);
                    for (int starting : startingLocs) {
                        if (starting + blockLen <= upperLimit) {
                            canPlace = true;
                            break;
                        }
                    }
                    if (canPlace) break;
                }
                res.add(canPlace);
            }
        }

        return res;
    }
}