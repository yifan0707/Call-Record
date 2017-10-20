package au.edu.uq.itee.comp3506.assn2.entities;

public class Node<T> {
	private T element;
	private Node nextNode;
	
	public Node(T object){
		this.element=object;
		nextNode=null;
	}
	
	public Node(T object,Node node){
		this.element=object;
		this.nextNode=node;
	}
	
	public Node getNext(){
		return nextNode;
	}
	
	public void setNext(Node node){
		this.nextNode=node;
	}
	
	public T getElement(){
		return this.element;
	}
	public void setElement(T object){
		this.element=object;
	}
	
	public boolean hasNext(){
		if(nextNode==null){
			return false;
		}else{
			return true;
		}
	}
}
