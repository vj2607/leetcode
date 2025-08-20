class LFUCache {
private static class Node{
		int key;
		int value;
		int freq=1;
		Node next;
		Node prev;
		
		Node(int key,int value){
			this.key=key;
			this.value=value;
			next=null;
			prev=null;
		}
	}
	private static class DoublylinkedList{
		Node head,tail;
		int len=0;
		
		public DoublylinkedList() {
			head= new Node(-1,-1);
			tail=new Node(-1,-1);
			head.next=tail;
			tail.prev=head;
			
		}
		
		void addToHead(Node node) {
			node.next=head.next;
			head.next.prev=node;
			node.prev=head;
			head.next=node;
			len++;
		}
		
	 
	   
	   void removeNode(Node node) {
		   node.prev.next = node.next;
		   node.next.prev=node.prev;
		   len--;
	   }
	   Node removeTail() {
		   if(len==0) {
			   return null;
		   }
		   Node lru = tail.prev;
		   removeNode(lru);
		   return lru;
	   }
	   boolean isEmpty() {
		   return len==0;
	   }
	   
	 
	}
	
	   int minFreq=0;
	   int capacity;
	   int size=0;
	   HashMap<Integer,Node> keyToNode ;
	   HashMap<Integer,DoublylinkedList> freqToNode ;
	   
	   LFUCache(int cap){
		   this.capacity=cap;
		   keyToNode= new HashMap<>();
		   freqToNode= new HashMap<>();
	   }
	   
	   public int get(int key) {
		   Node node = keyToNode.get(key);
		   if(node==null)
			   return -1;
		   
		   else {
			 util(node);
			 return node.value;
		   }
		   }
	   
	   
	  public void put(int key,int value) {
		   if(capacity==0) return;
		   Node node = keyToNode.get(key);
		   if(node==null) {
			   
                if(size==capacity) {
                	DoublylinkedList oldList = freqToNode.get(minFreq);
                	Node nodeToRemove = oldList.removeTail();
                	keyToNode.remove(nodeToRemove.key);
                	size--;
				   
			   }
			  
			   Node newNode = new Node(key,value);
			  
			   minFreq=1;
			   keyToNode.put(key, newNode);
			   freqToNode.computeIfAbsent(minFreq, f-> new DoublylinkedList()).addToHead(newNode) ;
			   size++;
			   
			   
		   }
		   else {
			   node.value=value;
			   util(node);
		   }
		   
	   }
	   
	   
	   
	   
	   
	   
	   void util(Node node) {
		   int oldFreq= node.freq;
		   DoublylinkedList oldList = freqToNode.get(oldFreq);
		   oldList.removeNode(node);
		   
		   if(oldFreq==minFreq && oldList.isEmpty())
			    minFreq++;
		   
		   node.freq++;
		   freqToNode.computeIfAbsent(node.freq, f-> new DoublylinkedList()).addToHead(node) ;
		   
	   }
    
   
    
    
  
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */