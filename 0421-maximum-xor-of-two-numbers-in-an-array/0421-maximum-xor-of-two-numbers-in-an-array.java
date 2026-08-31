class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();

        for(int num : nums){
            trie.insert(num);
        }

        int max = 0;

        for(int num : nums){
            max = Math.max(max, trie.getMaxXor(num));
        }

        return max;
    }
}

class Node{
    Node[] links = new Node[2];

    boolean containsKey(int bit){
        return links[bit] != null;
    }

    void put(int bit, Node node){
        links[bit] = node;
    }

    Node get(int bit){
        return links[bit];
    }
}

class Trie{
    Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(int num){
        Node node = root;

        for(int i=30; i>=0; i--){

            int bit = (num >> i) & 1;

            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    public int getMaxXor(int num){
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