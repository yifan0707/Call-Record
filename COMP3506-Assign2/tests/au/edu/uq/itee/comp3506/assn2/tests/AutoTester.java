package au.edu.uq.itee.comp3506.assn2.tests;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import au.edu.uq.itee.comp3506.assn2.api.TestAPI;
import au.edu.uq.itee.comp3506.assn2.entities.CallRecord;
import au.edu.uq.itee.comp3506.assn2.entities.DataReader;
import au.edu.uq.itee.comp3506.assn2.entities.LinkedList;
import au.edu.uq.itee.comp3506.assn2.entities.SwitchElement;
import au.edu.uq.itee.comp3506.assn2.entities.SwitchList;
import au.edu.uq.itee.comp3506.assn2.entities.CallPair;

/**
 * Hook class used by automated testing tool.
 * The testing tool will instantiate an object of this class to test the functionality of your assignment.
 * You must implement the method and constructor stubs below so that they call the necessary code in your application.
 * 
 * @author 
 */
public final class AutoTester implements TestAPI {
	// TODO Provide any data members required for the methods below to work correctly with your application.
	DataReader dataReader;
	LinkedList<CallPair> phoneNumberPairList;
	CallPair phoneNumber;
	SwitchList switchesList;
	public AutoTester() throws IOException{
		// TODO Create and initialise any objects required by the methods below.
		dataReader=new DataReader();
		dataReader.openFile();
		switchesList=dataReader.readSwitchesFile();
		dataReader.readRecordsFile();
		dataReader.closeFile();
		
	}
	
	/**
	 * 
	 * Runtime Complexity of used method: 
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);	
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 *  5. getCaller()					Runtime Complexity: O(1);
	 *  6. getReceiver()				Runtime Complexity: O(1);
	 *  
	 * In the method, the for loop has been used which is linear runtime complexity. Meanwhile other methods' 
	 * runtime complexity is constant. Thus the whole runtime complexity of the method is O(n) 
	 * Runtime Complexity of the whole method:O(n) 
	 */
	@Override
	public List<Long> called(long dialler) {
		List<Long> receivers=new ArrayList<Long>();
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=(CallPair)phoneNumberPairList.reverseHead().getElement();
				if(element.getCaller()==dialler){
					receivers.add(element.getReceiver());
			}
		}
		return receivers;
	}

	
	
	/**
	 * 
	 * Runtime Complexity of used method: 
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);	
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 *  5. getCaller()					Runtime Complexity: O(1);
	 *  6. getReceiver()				Runtime Complexity: O(1);
	 *  7. isInTime()					Runtime Complexity:	O(1);
	 *  
	 * In the method, the for loop has been used which is linear runtime complexity. Meanwhile other methods' 
	 * runtime complexity is constant. Thus the whole runtime complexity of the method is O(n) 
	 * Runtime Complexity of the whole method:O(n) 
	 */
	@Override
	public List<Long> called(long dialler, LocalDateTime startTime, LocalDateTime endTime) {
		List<Long> receivers=new ArrayList<Long>();
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=phoneNumberPairList.reverseHead().getElement();
				if(element.isIntime(startTime, endTime)){
					if(element.getCaller()==dialler){
						receivers.add(element.getReceiver());
					}
				}
		}
		return receivers;
	}

	
	
	/**
	 * 
	 * Runtime Complexity of used method: 
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);	
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 *  5. getCaller()					Runtime Complexity: O(1);
	 *  6. getReceiver()				Runtime Complexity: O(1);
	 *  
	 * In the method, the for loop has been used which is linear runtime complexity. Meanwhile other methods' 
	 * runtime complexity is constant. Thus the whole runtime complexity of the method is O(n) 
	 * Runtime Complexity of the whole method:O(n) 
	 */
	@Override
	public List<Long> callers(long receiver) {
		List<Long> caller=new ArrayList<Long>();
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=(CallPair)phoneNumberPairList.reverseHead().getElement();
				if(element.getReceiver()==receiver){
					caller.add(element.getCaller());
			}
		}
		return caller;
	}

	
	
	@Override
	public List<Long> callers(long receiver, LocalDateTime startTime, LocalDateTime endTime) {
		List<Long> callers=new ArrayList<Long>();
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=(CallPair)phoneNumberPairList.reverseHead().getElement();
				if(element.isIntime(startTime, endTime)){
					if(element.getReceiver()==receiver){
						callers.add(element.getCaller());
					}
				}
		}
		return callers;
	}

	@Override
	public List<Integer> findConnectionFault(long dialler) {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		List<Integer> faultSwitches=new ArrayList<>();
		//combine all the connectionPath into one linkList 
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair callpair=phoneNumberPairList.reverseHead().getElement();
			if(callpair.getCaller()==dialler){
				if(getfaultSwitchID(callpair)!=0){
					faultSwitches.add(getfaultSwitchID(callpair));
				}
			}
		}
		return faultSwitches;
	}

	@Override
	public List<Integer> findConnectionFault(long dialler, LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		List<Integer> faultSwitches=new ArrayList<>();
		//combine all the connectionPath into one linkList
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair callpair=phoneNumberPairList.reverseHead().getElement();
			//is call record within time
			if(callpair.isIntime(startTime, endTime)){
				//is the assigned caller
				if(callpair.getCaller()==dialler){
					//does any switch wrong
					if(getfaultSwitchID(callpair)!=0){
						faultSwitches.add(getfaultSwitchID(callpair));
					}
				}
			}
		}
		return faultSwitches;
	}

	@Override
	public List<Integer> findReceivingFault(long reciever) {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		List<Integer> faultSwitches=new ArrayList<>();
		//combine all the connectionPath into one linkList 
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair callpair=phoneNumberPairList.reverseHead().getElement();
			if(callpair.getReceiver()==reciever){
				if(getfaultSwitchID(callpair)!=0){
					faultSwitches.add(getfaultSwitchID(callpair));
				}
			}
		}
		return faultSwitches;
	}

	@Override
	public List<Integer> findReceivingFault(long reciever, LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		List<Integer> faultSwitches=new ArrayList<>();
		//combine all the connectionPath into one linkList 
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair callpair=phoneNumberPairList.reverseHead().getElement();
			if(callpair.isIntime(startTime, endTime)){
				if(callpair.getReceiver()==reciever){
					if(getfaultSwitchID(callpair)!=0){
						faultSwitches.add(getfaultSwitchID(callpair));
					}
				}
			}
		}
		return faultSwitches;
	}

	
	@Override
	public int maxConnections() {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		LinkedList<Integer> allConnectionPath=new LinkedList<>();
		//combine all the connectionPath into one linkList 
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			allConnectionPath.combineLinkList(phoneNumberPairList.reverseHead().getElement().getConnectionPath());
		}
		
		int maxCount=0;
		int maxCountSwitch=0;
		for(int i=0;i<allConnectionPath.getSize();i++){
			int switchID=allConnectionPath.reverseHead().getElement();
			
			for(int j=0;j<switchesList.getCapacity();j++){
				SwitchElement currentSwitch=switchesList.getElement(j);
				if(currentSwitch.getKey()==switchID){
					currentSwitch.addCount();
					if(maxCount<currentSwitch.getValue()){
						maxCount=currentSwitch.getValue();
						maxCountSwitch=currentSwitch.getKey();
					}else if(maxCount==currentSwitch.getValue()&&
							maxCountSwitch>currentSwitch.getKey()){
						maxCountSwitch=currentSwitch.getKey();
					}
				}
			}
		}
		return maxCountSwitch;
	}

	@Override
	public int maxConnections(LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		LinkedList<Integer> allConnectionPath=new LinkedList<>();
		//combine all the connectionPath into one linkList 
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=phoneNumberPairList.reverseHead().getElement();
			if(element.isIntime(startTime, endTime)){
				allConnectionPath.combineLinkList(element.getConnectionPath());
			}
		}
		
		int maxCount=0;
		int maxCountSwitch=0;
		for(int i=0;i<allConnectionPath.getSize();i++){
			int switchID=allConnectionPath.reverseHead().getElement();
			
			for(int j=0;j<switchesList.getCapacity();j++){
				SwitchElement currentSwitch=switchesList.getElement(j);
				if(currentSwitch.getKey()==switchID){
					currentSwitch.addCount();
					if(maxCount<currentSwitch.getValue()){
						maxCount=currentSwitch.getValue();
						maxCountSwitch=currentSwitch.getKey();
					}else if(maxCount==currentSwitch.getValue()&&
							maxCountSwitch>currentSwitch.getKey()){
						maxCountSwitch=currentSwitch.getKey();
					}
				}
			}
		}
		return maxCountSwitch;
	}

	@Override
	public int minConnections() {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		LinkedList<Integer> allConnectionPath=new LinkedList<>();
		//combine all the connectionPath into one linkList 
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			allConnectionPath.combineLinkList(phoneNumberPairList.reverseHead().getElement().getConnectionPath());
		}
		
		for(int i=0;i<allConnectionPath.getSize();i++){
			int switchID=allConnectionPath.reverseHead().getElement();
			for(int j=0;j<switchesList.getCapacity();j++){
				SwitchElement currentSwitch=switchesList.getElement(j);
				if(currentSwitch.getKey()==switchID){
					currentSwitch.addCount();
				}
			}
		}
		int minID=100000;
		int minCount=allConnectionPath.getSize();
		for(int j=0;j<switchesList.getCapacity();j++){
			SwitchElement currentSwitch=switchesList.getElement(j);
			int currentCount=currentSwitch.getValue();
			int currentID=currentSwitch.getKey();
			if(minCount>currentCount){
				minCount=currentCount;
				minID=currentID;
			}else if(minCount==currentCount&&
					minID>currentID){
				minID=currentID;
			}	
		}
		return minID;
	}

	@Override
	public int minConnections(LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		LinkedList<Integer> allConnectionPath=new LinkedList<>();
		//combine all the connectionPath into one linkList 
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=phoneNumberPairList.reverseHead().getElement();
			if(element.isIntime(startTime, endTime)){
				allConnectionPath.combineLinkList(element.getConnectionPath());
			}
		}
		for(int i=0;i<allConnectionPath.getSize();i++){
			int switchID=allConnectionPath.reverseHead().getElement();
			for(int j=0;j<switchesList.getCapacity();j++){
				SwitchElement currentSwitch=switchesList.getElement(j);
				if(currentSwitch.getKey()==switchID){
					currentSwitch.addCount();
				}
			}
		}
		
		int minID=100000;
		int minCount=allConnectionPath.getSize();
		for(int j=0;j<switchesList.getCapacity();j++){
			SwitchElement currentSwitch=switchesList.getElement(j);
			int currentCount=currentSwitch.getValue();
			int currentID=currentSwitch.getKey();
			
			if(minCount>currentSwitch.getValue()){
				minCount=currentSwitch.getValue();
				minID=currentSwitch.getKey();
			}else if(minCount==currentSwitch.getValue()&&
					minID>currentSwitch.getKey()){
				minID=currentSwitch.getKey();
			}	
		}
		return minID;
	}

	@Override
	public List<CallRecord> callsMade(LocalDateTime startTime, LocalDateTime endTime) {
		List<CallRecord> callRecords=new ArrayList<>();
		phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair callpair=phoneNumberPairList.reverseHead().getElement();
			List<Integer> connectionPath=new ArrayList<Integer>();
			if(callpair.isIntime(startTime, endTime)){
				for(int j=0;j<callpair.getConnectionPath().getSize();j++){
					if(callpair.getConnectionPath().getSize()!=0){
						connectionPath.add(((int)callpair.getConnectionPath().reverseHead().getElement()));
					}
				}
			}
			callRecords.add(new CallRecord(callpair.getCaller(), callpair.getReceiver(),
	                  callpair.getCallerSwitch(), callpair.getReceiverSwitch(),
	                  connectionPath, callpair.getTimeStamp()));
		}
		return callRecords;
	}
	
	public static void main(String[] args) throws IOException {
		AutoTester test = new AutoTester();
		long number=3742128469L;
		test.called(number);
		System.out.println(test.findConnectionFault(number));
		//System.out.println(test.findConnectionFault(number).size());
		//System.out.print(test.minConnections());
		//System.out.println("AutoTester Stub");
	}
	
	
	public int getfaultSwitchID(CallPair callpair){
		LinkedList<Integer> connectionPath=callpair.getConnectionPath();	
		// connection Path is null then the callerSwitch is fault 
		if(connectionPath.getSize()==0){
			return callpair.getCallerSwitch();
		}
		//the connectionpath's size is one and the fault is at the CallerSwitch
		else if(connectionPath.getSize()==1){
			if((int)connectionPath.getHead().getElement()!=callpair.getReceiverSwitch()){
				return (int)connectionPath.getHead().getElement();
			}
		}
		if(connectionPath.getSize()>=2){
			//the final switch in the connection path is not the same as receiver's switch
			if((int)connectionPath.getTail().getElement()!=callpair.getReceiverSwitch()){
				return (int)connectionPath.getTail().getElement();
				}
		}
		return 0;
	}
}