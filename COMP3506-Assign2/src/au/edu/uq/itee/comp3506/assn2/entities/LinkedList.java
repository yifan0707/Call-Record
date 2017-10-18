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
}
