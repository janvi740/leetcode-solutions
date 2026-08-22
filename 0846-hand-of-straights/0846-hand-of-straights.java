class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){
            return false;
        }

        Arrays.sort(hand);

        Map<Integer, Integer> freq = new HashMap<>();

        for(int card : hand){
            freq.put(card, freq.getOrDefault(card,0)+1);
        }

        for(int card : hand){

            if(freq.get(card) == 0){
                continue;
            }

            for(int next=card; next<card+groupSize; next++){

                if(freq.getOrDefault(next,0) == 0){
                    return false;
                }

                freq.put(next, freq.get(next)-1);
            }
        }

        return true;
    }
}