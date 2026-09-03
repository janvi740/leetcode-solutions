class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task : tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for(int count : freq){
            if(count > 0){
                maxHeap.offer(count);
            }
        }

        int time = 0;

        while(!maxHeap.isEmpty()){
            int cycle = n+1;

            List<Integer> remaining = new ArrayList<>();

            while(cycle > 0 && !maxHeap.isEmpty()){

                int count = maxHeap.poll();
                count--;

                if(count > 0){
                    remaining.add(count);
                }

                time++;
                cycle--;
            }

            for(int count : remaining){
                maxHeap.offer(count);
            }

            if(!maxHeap.isEmpty()){
                time += cycle;
            }
        }

        return time;
    }
}