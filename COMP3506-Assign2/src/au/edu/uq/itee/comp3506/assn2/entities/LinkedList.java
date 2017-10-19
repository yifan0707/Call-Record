package au.edu.uq.itee.comp3506.assn2.entities;

public class LinkedList<T> {
	private int size;
	private Node<T> head;
	private Node<T> tail;

	public LinkedList(){
		size=0;
		head=null;
		tail=null;
	}
	
	public int getSize(){
		return size;
	}
	
	public Node getTail(){
		return tail;
	}
	
	public Node getHead(){
		return head;
	}
	
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
			return tail;
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
	 * @return the original head node
	 */
	public Node<T> reverseHead(){
		Node temp= head;
		head=head.getNext();
		tail.setNext(temp);
		tail=temp;
		return temp;
	}
	
	
	public void combineLinkList(LinkedList<T> linkedList){
		//current linked list empty
		if(linkedList==null){
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
