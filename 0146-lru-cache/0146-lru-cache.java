class LRUCache {

 private class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node (int k , int v){
            this.key=k;
            this.val=v;
        }
    }
    int size;
    int capacity;
    HashMap<Integer,Node> map;
    Node head,tail;

   


    public LRUCache(int capacity) {
        this.capacity=capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null)
         return -1;

         else{
           
            moveToHead(node);
            return node.val;
         }
    }

    public void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void moveToHead(Node node){
            removeNode(node);
            addToHead(node);
    }

    public void addToHead(Node node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    public Node removeTail(){
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
    
    public void put(int key, int value) {

        Node node = map.get(key);
        if(node==null){
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size>capacity){
                Node lru = removeTail();
                map.remove(lru.key);
                size--;
            }

        }
        else{
            node.val= value;
            moveToHead(node);
        }
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */