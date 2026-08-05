class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){

                if(matrix[row][col] == '1'){
                    heights[col]++;
                }
                else{
                    heights[col] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    public int largestRectangle(int[] heights){
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<=n; i++){

            int currHeight = (i==n) ? 0 : heights[i];

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){

                int height = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;

                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}