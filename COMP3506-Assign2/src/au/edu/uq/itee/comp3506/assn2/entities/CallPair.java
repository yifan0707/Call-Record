package au.edu.uq.itee.comp3506.assn2.entities;

import java.time.LocalDateTime;

/*
 * this class will be used to store the data of Caller , Receiver connection
 */
public class CallPair {
	private long caller;
	private long receiver;
	private final int lineNumber;
	private LocalDateTime timeStamp;
	private LinkedList<Integer> connectionPath;
	private int callerSwitch;
	private int receiverSwitch;
	
	public LinkedList<Integer> getConnectionPath() {
		return connectionPath;
	}

	public void setConnectionPath(LinkedList<Integer> connectionPath) {
		this.connectionPath = connectionPath;
	}

	public int getCallerSwitch() {
		return callerSwitch;
	}

	public void setCallerSwitch(int callerSwitch) {
		this.callerSwitch = callerSwitch;
	}

	public int getReceiverSwitch() {
		return receiverSwitch;
	}

	public void setReceiverSwitch(int receiverSwitch) {
		this.receiverSwitch = receiverSwitch;
	}

	public CallPair(Integer lineNumber){
		this.caller=0;
		this.receiver=0;
		this.lineNumber=lineNumber;
		this.timeStamp=null;
		this.connectionPath=null;
	}

	public long getCaller(){
		return caller;
	}
	
	public long getReceiver(){
		return receiver;
	}
	
	public int getLineNumber(){
		return lineNumber;
	}
	
	public LocalDateTime getTimeStamp(){
		return this.timeStamp;
	}
	
	public void setTimeStamp(LocalDateTime time){
		this.timeStamp=time;
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
	
	public boolean isIntime(LocalDateTime startTime,LocalDateTime endTime){
		//whether the day of month is within range
		if(timeStamp.getDayOfMonth()>=startTime.getDayOfMonth()&&
				timeStamp.getDayOfMonth()<=endTime.getDayOfMonth()){
			//whether the hour is within range 
			if(timeStamp.getHour()>=startTime.getHour()&&
					timeStamp.getHour()<=endTime.getHour()){
				//whether the minute is within range
				if(timeStamp.getMinute()>=startTime.getMinute()&&
						timeStamp.getMinute()<=endTime.getMinute()){
					//whether the second is within range
					if(timeStamp.getSecond()>=startTime.getSecond()&&
							timeStamp.getSecond()<=endTime.getSecond()){
						//whether the nano is within range
						if(timeStamp.getNano()>=startTime.getNano()&&
								timeStamp.getNano()<=endTime.getNano()){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
}
