package au.edu.uq.itee.comp3506.assn2.entities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DataReader {
	
	private Scanner switches;
	private Scanner callRecords;
	private Scanner callRecordsShort;
	private Scanner lineScanner;
	private LinkedList<CallPair> phoneNumberList;
	private SwitchList switchList;
	
	int[] switchesID=new int[20];
	
	public void openFile() throws IOException{
		phoneNumberList=new LinkedList<CallPair>();
		
		try{
			switches= new Scanner(new File("./data/switches.txt"));
			callRecords=new Scanner(new File("./data/call-records.txt"));
			callRecordsShort=new Scanner(new File("./data/call-records-short.txt"));
		}catch(Exception e){
			throw new IOException("File does not found!");
		}	
	}
	
	public SwitchList readSwitchesFile(){
		int number=0;
		if(switches.hasNextInt()){
			if(switches.nextInt()==1000){
				switchList=new SwitchList(1000);
				while(switches.hasNextInt()){
					this.switchList.setValue(number, new SwitchElement(switches.nextInt()));
					number+=1;
				}
			}
		}
		return switchList;
	}
	
	public void readRecordsFile(){
		int lineNumber=0;
		int invalidNumber=0;
		//loop through every line
		while(callRecordsShort.hasNextLine()){
			lineNumber+=1;
			int tokenNumber=0;
			String record=callRecordsShort.nextLine();
			lineScanner=new Scanner(record);
			
			//initialise a connectionPath that contains CallerSwitch& ReceiverSwitch
			LinkedList<Integer> connectionPath=new LinkedList<Integer>();
			//initialise a callPair with its lineNumber
			CallPair callPair=new CallPair(lineNumber);
			//info before time stamp
			
			while(lineScanner.hasNextLong()){
				tokenNumber+=1;
				Long nextLong=lineScanner.nextLong();
				System.out.println(nextLong);
				//whether the number is SwitchID or PhoneNumber
				if(nextLong<=100000&&nextLong>=10000){
					int nextInt=nextLong.intValue();
					connectionPath.addLast(new Node<Integer> (nextInt));
				}else if(nextLong>=1000000000){
					//store phoneNumber as caller and receiver according to accessing order
					if(callPair.getCaller()==0){
						callPair.setCaller(nextLong);
					}else{
						callPair.setReceiver(nextLong);
					}
				}
			}
			//info of time stamp
			while(lineScanner.hasNext()){
				String timeStamp=lineScanner.next();
				LocalDateTime time = LocalDateTime.parse(timeStamp);
				callPair.setTimeStamp(time);
			}
			
			//token sum of CallerSwitch, ReceiverSwitch and connectionPath should be bigger than 3  
			if(tokenNumber<=3){
				continue;
			}else{
				/*Remove the CallerSwitch and ReceiveSwitch from connectionPath
				 *and store the data into callPair 
				*/
				callPair.setCallerSwitch((Integer)connectionPath.removeHead().getElement());
				callPair.setReceiverSwitch((Integer)connectionPath.removeTail().getElement());
				callPair.setConnectionPath(connectionPath);
				//System.out.println(callPair.getCallerSwitch()+"Head");
				//System.out.println(callPair.getReceiverSwitch()+"Tail");
				System.out.println(isValid(callPair));
				//c
				if(isValid(callPair)){
					phoneNumberList.addLast(new Node(callPair));
				}else{
					invalidNumber+=1;
				}
				//Node ha=new Node(phoneNumber);
				//System.out.println(ha.getElement().getReceiver()+"before");
				//System.out.println(ha.getElement().getReceiver()+"after");
			}
		}
		//System.out.println(invalidNumber); only 2 invalid
	}
	
	public void closeFile(){
		switches.close();
		callRecords.close();
		callRecordsShort.close();
	}
	
	public LinkedList<CallPair> getphoneNumberLinkedList(){
		return phoneNumberList;
	}
	
	
	public boolean isValid(CallPair callpair){
		LinkedList<Integer> connectionPath=callpair.getConnectionPath();
		int receiverSwitch=callpair.getReceiverSwitch();
		int callerSwitch=callpair.getCallerSwitch();
		if(connectionPath.getSize()>0){
			//First node in connection path is not the same with callerSwitchID
			if(callerSwitch!=(int)connectionPath.getHead().getElement()){
				return false;
			}
		}
		return true;
	}
}
