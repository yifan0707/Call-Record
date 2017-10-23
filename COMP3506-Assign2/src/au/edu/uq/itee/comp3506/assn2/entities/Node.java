package au.edu.uq.itee.comp3506.assn2.entities;

public class Node<T> {
	private T element;				//Element that the node carried
	private Node nextNode;			//Info of NextNode
	
	/**
	 * constructor of the Node class
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @param object
	 */
	public Node(T object){
		this.element=object;
		nextNode=null;
	}
	
	/**
	 * constructor of the Node class
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @param object
	 * @param node
	 */
	public Node(T object,Node node){
		this.element=object;
		this.nextNode=node;
	}
	
	/**
	 * get method of the next node
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @return nextNode
	 */
	public Node getNext(){
		return nextNode;
	}
	
	/**
	 * set method of the nextNode
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @param node
	 */
	public void setNext(Node node){
		this.nextNode=node;
	}
	
	/**
	 * get method of the current element
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @return
	 */
	public T getElement(){
		return this.element;
	}
	
	/**
	 * set method of the current element
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1) 
	 * @param object
	 */
	public void setElement(T object){
		this.element=object;
	}
	
	/**
	 * method used to check whether current node has next node info
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @return
	 */
	public boolean hasNext(){
		if(nextNode==null){
			return false;
		}else{
			return true;
		}
	}
}
