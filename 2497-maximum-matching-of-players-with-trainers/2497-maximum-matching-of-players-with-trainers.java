class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int j=0;
        int i=0;
        for( i=0 ; i<players.length && j<trainers.length ; j++ ){
                if(players[i] <=trainers[j])
                    i++;
        }
        return i;
    }
}