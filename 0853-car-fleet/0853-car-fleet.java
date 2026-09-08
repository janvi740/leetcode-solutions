class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for(int i=0; i<position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for(int i=0; i<cars.length; i++){

            double time = (double) (target - cars[i][0]) / cars[i][1];

            if(stack.isEmpty()){
                stack.push(time);
            }

            else if(!stack.isEmpty() && time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size(); 
    }
}