package au.edu.uq.itee.comp3506.assn2.entities;

/*
 * this class will be used to store the data of Caller , Receiver connection
 */
public class PhoneNumber {
	private long caller;
	private long receiver;
	public PhoneNumber(long head,long tail){
		this.caller=head;
		this.receiver=tail;
	}
	public PhoneNumber(){
		this.caller=0;
		this.receiver=0;
	}

	public long getCaller(){
		return caller;
	}
	
	public long getReceiver(){
		return receiver;
	}
	
	public void setCaller(long caller){
		this.caller=caller;
	}
	
	public void setReceiver(long receiver){
		this.receiver=receiver;
	}
	
	public void reset(){
		this.caller=0;
		this.receiver=0;
	}
	
}
