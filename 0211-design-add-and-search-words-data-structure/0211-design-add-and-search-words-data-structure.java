class Node{
    Node[] links = new Node[128];
    boolean flag = false;

    boolean containsKey(char ch){
        return links[ch] != null;
    }

    void put(char ch, Node node){
        links[ch] = node;
    }

    Node get(char ch){
        return links[ch];
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }
    
    public boolean search(String word) {
        return dfs(0, root, word);
    }

    public boolean dfs(int index, Node node, String word){

        if(index == word.length()){
            return node.isEnd();
        }

        char ch = word.charAt(index);

        if(ch != '.'){

            if(!node.containsKey(ch)){
                return false;
            }

            return dfs(index+1, node.get(ch), word);
        }

        for(int i=0; i<128; i++){

            if(node.links[i] != null){

                if(dfs(index+1, node.links[i], word)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */