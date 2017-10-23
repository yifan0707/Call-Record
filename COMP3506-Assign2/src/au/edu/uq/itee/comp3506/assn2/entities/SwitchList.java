package au.edu.uq.itee.comp3506.assn2.entities;

/**
 * the class is mainly created as the list that contains all of the switch element
 *
 * all of the variables/methods are primitive types or primitive operations
 *
 * The Runtime Complexity: 		O(1)
 * The SpaceUsage Complexity: 	O(n)
 */
public class SwitchList {
	private SwitchElement[] elements;		//List that contains all the switch element
	private int capacity;					//list capacity

	/**
	 * constructor of the switchList 
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @param capacity
	 */
	public SwitchList(int capacity){
		this.capacity=capacity;
		elements=new SwitchElement[capacity];
	}
	
	/**
	 * set method of the linked list element value according to given index
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @param index
	 * @param se
	 */
	public void setValue(int index,SwitchElement se){
		this.elements[index]=se;
	}
	
	/**
	 * get method of the element of the linked list according to the given index
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @param index
	 * @return
	 */
	public SwitchElement getElement(int index){
		return this.elements[index];
	}
	
	/**
	 * get method of the capacity
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @return
	 */
	public int getCapacity(){
		return capacity;
	}
	

	
}
