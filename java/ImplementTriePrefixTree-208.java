// 1. Trie有点类似于多叉树和链表的结合
//   这是对TrieNode的定义，
//   c用于存储当前节点的值
//   TrieNode child[]用于存储后面节点
//   isEnd用于表示是否为最后一个节点 
//   public char c;
//   public TrieNode child[];
//   public boolean isEnd;
class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode('/');
    }
    public void insert(String word) {
        if(word.length()==0)return;
        char[] wordArr = word.toCharArray();
        TrieNode cur = root;
        for(int i=0;i<wordArr.length;i++){
            if(cur.child[wordArr[i]-'a']==null){
                cur.child[wordArr[i]-'a'] = new TrieNode(wordArr[i]);
                cur = cur.child[wordArr[i]-'a'];
            }else{
                cur = cur.child[wordArr[i]-'a'];
            }
        }
        cur.isEnd = true;
        
    }
    
    public boolean search(String word) {
        if(word.length()==0)return false;
        char[] wordArr = word.toCharArray();
        TrieNode cur = root;
        for(int i=0;i<wordArr.length;i++){
            if(cur.child[wordArr[i]-'a']==null){
                return false;
            }else{
                cur = cur.child[wordArr[i]-'a'];
            }
        }
        if(cur.isEnd==true){
            return true;
        }else {
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length()==0)return false;
        char[] wordArr = prefix.toCharArray();
        TrieNode cur = root;
        for(int i=0;i<wordArr.length;i++){
            if(cur.child[wordArr[i]-'a']==null){
                return false;
            }else{
                cur = cur.child[wordArr[i]-'a'];
            }
        }
        return true;
    }
}
class TrieNode{
    public char c;
    public TrieNode child[];
    public boolean isEnd;
    public TrieNode(char c) {
        this.c = c;
        this.child = new TrieNode[26];
        this.isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
