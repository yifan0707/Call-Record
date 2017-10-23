package au.edu.uq.itee.comp3506.assn2.entities;

public class LinkedList<T> {
	private int size;		//size of the linked list
	private Node<T> head;	//head node of the linked list
	private Node<T> tail;	//tail node of the linked list

	/**
	 * constructor of the linked list
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 */
	public LinkedList(){
		size=0;
		head=null;
		tail=null;
	}

	/**
	 * get method of the size of the linked list
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 * @return	current size of the linked list
	 */
	public int getSize(){
		return size;
	}

	/**
	 * get method of the tail of the linked list
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 * @return	current tail node of the linked list
	 */
	public Node getTail(){
		return tail;
	}

	/**
	 * get method of the tail of the linked list
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 * @return	current head node of the linked list
	 */
	public Node getHead(){
		return head;
	}



	/**
	 * add a nextNode to the last of the linked list
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 */
	public void addLast(Node newNode){
		if(newNode==null){
			return;
		}else{
			if(size==0){
				head=newNode;
				tail=head;
				size+=1;
			}else{
				tail.setNext(newNode);
				tail=newNode;
				size+=1;
			}
		}
	}


	/**
	 * remove the head node of the linked list
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 * @return	previous head node of the linked list/ null if no head node is null
	 */
	public Node removeHead(){
		Node temp;
		if(size==2){
			temp=head;
			head=tail;
			size-=1;
			return temp;
		}else if(size==1){
			temp=head;
			tail=null;
			head=null;
			size=0;
			return temp;
		}else if(size==0){
			return null;
		}else if(size>2){
			temp=head;
			head=head.getNext();
			size-=1;
			return temp;
		}
		return null;
	}


	/**
	 * remove the tail node of the linked list
	 * Runtime Complexity:			O(n)
	 * Space Usage Complexity: 		O(1)
	 * @return	previous tail node of the linked list/ null if no tail node is null
	 */
	public Node removeTail(){
		Node temp;
		if(size==2){
			temp=tail;
			tail=head;
			head.setNext(null);
			size-=1;
			return temp;
		}else if(size==1){
			size-=1;
			temp=tail;
			tail=null;
			head=null;
			return temp;
		}else if(size==0){
			return null;
		}else if(size==3){
			size-=1;
			temp=tail;
			tail=head.getNext();
			tail.setNext(null);
			return temp;
		}else if(size>3){
			temp=tail;
			Node nextNode=head.getNext();
			for(int i=0;i<size-3;i++){
				nextNode=nextNode.getNext();
			}
			size-=1;
			tail=nextNode;
			tail.setNext(null);
			return temp;
		}
		return null;
	}
	
	/**
	 * this method would move the first node to the last
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 * @return the original head node
	 */
	public Node<T> reverseHead(){
		Node temp= head;
		head=head.getNext();
		tail.setNext(temp);
		tail=temp;
		return temp;
	}
	
	
	/**
	 * method that used to combining two linked list into one
	 * Runtime Complexity:			O(1)
	 * Space Usage Complexity: 		O(1)
	 * @param linkedList
	 */
	public void combineLinkList(LinkedList<T> linkedList){
		//current linked list empty
		if(linkedList.getSize()==0){
			return;
		}else{
			if(size==0){
				head=linkedList.getHead();
				tail=linkedList.getTail();
				size=linkedList.getSize();
			}else{
				this.tail.setNext(linkedList.getHead());
				this.tail=linkedList.getTail();
				size=size+linkedList.getSize();
			}
		}
	}
	
	
}
