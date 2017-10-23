package au.edu.uq.itee.comp3506.assn2.entities;

public class SwitchElement {
	private int id;				//switch identifier
	private int count;			//switch connection count
	
	/**
	 * constructor of the switch element
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 */
	public SwitchElement(){
		this.id=0;
		this.count=0;
	}
	
	/**
	 * constructor of the switch element
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @param key
	 */
	public SwitchElement(Integer key){
		this.id=key;
		this.count=0;
	}
	
	
	/**
	 * get method of the connection count
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @return count
	 */
	public int getValue(){
		return count;
	}
	
	/**
	 * get method of the ID
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 * @return
	 */
	public int getKey(){
		return id;
	}
	
	/**
	 * method that add one count of the current Switch
 	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(1)
	 */
	public void addCount(){
		count+=1;
	}
	
}
