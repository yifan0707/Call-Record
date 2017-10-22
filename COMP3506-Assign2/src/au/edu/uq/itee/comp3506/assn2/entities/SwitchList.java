package au.edu.uq.itee.comp3506.assn2.entities;

public class SwitchList {
	private SwitchElement[] elements;		//List that contains all the switch element
	private int capacity;					//list capacity

	/**
	 * constructor of the switchList 
	 * @param capacity
	 */
	public SwitchList(int capacity){
		this.capacity=capacity;
		elements=new SwitchElement[capacity];
	}
	
	public void setValue(int index,SwitchElement se){
		this.elements[index]=se;
	}
	
	public SwitchElement getElement(int index){
		return this.elements[index];
	}
	
	public int getCapacity(){
		return capacity;
	}
	

	
}
