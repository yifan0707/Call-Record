package au.edu.uq.itee.comp3506.assn2.entities;

public class SwitchElement {
	private int id;
	private int count;
	
	public SwitchElement(){
		this.id=0;
		this.count=0;
	}
	
	public SwitchElement(Integer key){
		this.id=key;
		this.count=0;
	}
	
	public int getValue(){
		return count;
	}
	
	public int getKey(){
		return id;
	}
	
	public void addCount(){
		count+=1;
	}
	
}
