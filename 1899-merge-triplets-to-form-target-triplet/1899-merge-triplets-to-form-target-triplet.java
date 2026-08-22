class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;

        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;

        for(int[] triplet : triplets){
            int a = triplet[0];
            int b = triplet[1];
            int c = triplet[2];

            if(a>target[0] || b>target[1] || c>target[2]){
                continue;
            }

            if(a == target[0]){
                foundX = true;
            }

            if(b == target[1]){
                foundY = true;
            }

            if(c == target[2]){
                foundZ = true;
            }

            if(foundX && foundY && foundZ){
                return true;
            }
        }

        return false;
    }
}