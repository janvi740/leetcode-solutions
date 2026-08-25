class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for(String word : words){
            trie.insert(word);
        }

        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dfs(board, i, j, trie.root, result);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int row, int col, Node node, List<String> result){

        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return;
        }

        char ch = board[row][col];

        if(ch == '#'){
            return;
        }

        if(!node.containsKey(ch)){
            return;
        }

        node = node.get(ch);

        if(node.getWord() != null){
            result.add(node.getWord());

            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row-1, col, node, result);
        dfs(board, row+1, col, node, result);
        dfs(board, row, col-1, node, result);
        dfs(board, row, col+1, node, result);

        board[row][col] = ch;
    }
}

class Node {
    Node[] links = new Node[26];
    String word = null;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setWord(String word) {
        this.word = word;
    }

    String getWord() {
        return word;
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }

        node.setWord(word);
    }
}