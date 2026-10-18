class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 0;
        int high = removable.length;
        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(canRemove(s, p, removable, mid)){
                ans = mid;
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return ans;
    }

    public boolean canRemove(String s, String p, int[] removable, int k){
        boolean[] removed = new boolean[s.length()];

        //Mark first k indices as removed
        for(int i=0; i<k; i++){
            removed[removable[i]] = true;
        }

        int j = 0;

        for(int i=0; i<s.length() && j<p.length(); i++){
            if(!removed[i] && s.charAt(i) == p.charAt(j)){
                j++;
            }
        }

        return j == p.length();
    }
}