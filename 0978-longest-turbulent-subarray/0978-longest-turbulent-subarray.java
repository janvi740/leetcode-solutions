class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        if(n == 1){
            return 1;
        }

        int len = arr[0] == arr[1] ? 1 : 2;
        int maxLen = len;

        for(int i=2; i<n; i++){

            int a = arr[i - 2];
            int b = arr[i - 1];
            int c = arr[i];

            if((a > b && b < c) || (a < b && b > c)){
                len++;
            }

            else if(b == c){
                len = 1;
            }

            else{
                len = 2;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}