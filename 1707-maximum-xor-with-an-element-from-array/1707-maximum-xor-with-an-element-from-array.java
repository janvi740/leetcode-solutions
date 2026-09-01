class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;

        int[][] offlineQueries = new int[q][3];

        for(int i=0; i<q; i++){

            offlineQueries[i][0] = queries[i][1];
            offlineQueries[i][1] = queries[i][0];
            offlineQueries[i][2] = i;
        }

        Arrays.sort(offlineQueries, (a,b) -> Integer.compare(a[0], b[0]));

        Trie trie = new Trie();

        int[] ans = new int[q];
        int index = 0;

        for(int[] query : offlineQueries){
            int mi = query[0];
            int xi = query[1];
            int orgIndex = query[2];

            while(index < nums.length && nums[index] <= mi){
                trie.insert(nums[index]);
                index++;
            }

            if(index == 0){
                ans[orgIndex] = -1;
            }

            else{
                ans[orgIndex] = trie.maxXor(xi);
            }
        }

        return ans;
    }
}

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }

    Node get(int bit) {
        return links[bit];
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;

        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    public int maxXor(int num){
        Node node = root;
        
        int maxXor = 0;

        for(int i=30; i>=0; i--){

            int bit = (num >> i) & 1;
            int opBit = 1 - bit;

            if(node.containsKey(opBit)){

                maxXor = maxXor | (1 << i);
                node = node.get(opBit);
            }

            else{
                node = node.get(bit);
            }
        }

        return maxXor;
    }
}