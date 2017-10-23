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
	DataReader dataReader;							//instance that would read the file
	LinkedList<CallPair> phoneNumberPairList;		//linked list that contains all the call pair
	SwitchList switchesList;						//List that contains all the switch ID
	public AutoTester() throws IOException{
		dataReader=new DataReader();
		dataReader.openFile();
		dataReader.readSwitchesFile();
		dataReader.readRecordFile();
		dataReader.readShortRecordsFile();
		dataReader.closeFile();
		
	}
	
	/**
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
	 *
	 * @param dialler The phone number that initiated the calls.
	 * @return
	 */
	@Override
	public List<Long> called(long dialler) {
		List<Long> receivers=new ArrayList<Long>();
		//phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		phoneNumberPairList=dataReader.getphoneNumberList2();
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
	 *
	 * @param dialler The phone number that initiated the calls.
	 * @param startTime Start of time period.
	 * @param endTime End of time period.
	 * @return
	 */
	@Override
	public List<Long> called(long dialler, LocalDateTime startTime, LocalDateTime endTime) {
		List<Long> receivers=new ArrayList<Long>();
		//phoneNumberPairList=dataReader.getphoneNumberLinkedList();
		phoneNumberPairList=dataReader.getphoneNumberList2();
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
	 *
	 * @param receiver The phone number that received the calls.
	 * @return
	 */
	@Override
	public List<Long> callers(long receiver) {
		List<Long> caller=new ArrayList<Long>();
		phoneNumberPairList=dataReader.getphoneNumberList2();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=phoneNumberPairList.reverseHead().getElement();
				if(element.getReceiver()==receiver){
					caller.add(element.getCaller());
			}
		}
		return caller;
	}



	/**
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
	public List<Long> callers(long receiver, LocalDateTime startTime, LocalDateTime endTime) {
		List<Long> callers=new ArrayList<Long>();
		phoneNumberPairList=dataReader.getphoneNumberList2();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair element=phoneNumberPairList.reverseHead().getElement();
				if(element.isIntime(startTime, endTime)){

					System.out.println("Linknumber:"+element.getLineNumber()+"within time should be called");
					if(element.getReceiver()==receiver){
						System.out.println("should be called");
						callers.add(element.getCaller());
					}
				}
		}
		return callers;
	}


	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 * 	5. getCaller()					Runtime Complexity: O(1);
	 * 	6. getfaultSwitchID()			Runtime Complexity: O(1);
	 * 	7. add()						Runtime Complexity: O(1);
	 *
	 * For this method only one for loop has been used to loop through phoneNumberList which will be iterated for
	 * n(phoneNumberList size) times. Other operation would be either took constant time or is primitive operations.
	 * Runtime complexity is: O(n)
	 * @param dialler The phone number that initiated the calls.
	 * @return List of switch ID that is faulty
	 */
	@Override
	public List<Integer> findConnectionFault(long dialler) {
		int j=0;
		phoneNumberPairList=dataReader.getphoneNumberList2();
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


	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 * 	5. isIntime()					Runtime Complexity: O(1);
	 * 	6. getCaller()					Runtime Complexity: O(1);
	 * 	7. getfaultSwitchID()			Runtime Complexity: O(1);
	 * 	8. add()						Runtime Complexity: O(1);
	 *
	 * For this method only one for loop has been used to loop through phoneNumberList which will be iterated for
	 * n(phoneNumberList size) times. Other operations/methods would be either took constant time or is primitive operations.
	 * Runtime complexity is: O(n)
	 * @param dialler The phone number that initiated the calls.
	 * @param startTime Start of time period.
	 * @param endTime End of time period.
	 * @return List of switch ID that is faulty
	 */
	@Override
	public List<Integer> findConnectionFault(long dialler, LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberList2();
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

	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 * 	5. getReceiver()				Runtime Complexity: O(1);
	 * 	6. getfaultSwitchID()			Runtime Complexity: O(1);
	 * 	7. add()						Runtime Complexity: O(1);
	 *
	 * For this method only one for loop has been used to loop through phoneNumberList which will be iterated for
	 * n(phoneNumberList size) times. Other operations/methods would be either took constant time or is primitive operations.
	 * Runtime complexity is: O(n)
	 * @param reciever The phone number that should have received the calls.
	 * @return
	 */
	@Override
	public List<Integer> findReceivingFault(long reciever) {
		phoneNumberPairList=dataReader.getphoneNumberList2();
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

	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 * 	5. isIntime()					Runtime Complexity: O(1);
	 * 	6. getReceiver()				Runtime Complexity: O(1);
	 * 	7. getfaultSwitchID()			Runtime Complexity: O(1);
	 * 	8. add()						Runtime Complexity: O(1);
	 *
	 * For this method only one for loop has been used to loop through phoneNumberList which will be iterated for
	 * n(phoneNumberList size) times. Other operations/methods would be either took constant time or is primitive operations.
	 * Runtime complexity is: O(n)
	 * @param reciever The phone number that should have received the calls.
	 * @return
	 */
	@Override
	public List<Integer> findReceivingFault(long reciever, LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberList2();
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





	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 *  5. combineLinkList()			Runtime Complexity: O(1);
	 *  6. getCapacity()				Runtime Complexity: O(1);
	 *  7. addCount()					Runtime Complexity: O(1);
	 *
	 * Initially, it will loop through the call record linked list and the methods inside the loop would execute
	 * n(LinkedList<CallPair> size) times. During each iteration, it would connection the current
	 * linkedList(connectionPath) behind the previous linkedList. As a result, all the connectionPath would be integrate
	 * into one big linkedList. Then, another for loop which size is m(LinkedList<Integer> size) would be called to loop
	 * through the big connectionPath linkedList and according to its switchID, find itself inside the switchList which
	 * will need a for loop through the switch list which size is 1000 and add one connection count.
	 * At last, return the maximum count Switch
	 * The runtime complexity of the method would be: O(n+m*1000*constant) => O(n)
	 *
	 * @return maxConnection count's switch ID
	 */
	@Override
	public int maxConnections() {
		phoneNumberPairList=dataReader.getphoneNumberList2();
		switchesList=dataReader.getSwitchList();
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

	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 *  5. isInTime()					Runtime Complexity:	O(1);
	 *  6. combineLinkList()			Runtime Complexity: O(1);
	 *  7. getCapacity()				Runtime Complexity: O(1);
	 *  8. addCount()					Runtime Complexity: O(1);
	 *
	 * Initially, it will loop through the call record linked list and the methods inside the loop would execute
	 * n(LinkedList<CallPair> size) times. During each iteration, it would connection the current
	 * linkedList(connectionPath) behind the previous linkedList. As a result, all the connectionPath would be integrate
	 * into one big linkedList. Then, another for loop which size is m(LinkedList<Integer> size) would be called to loop
	 * through the big connectionPath linkedList and according to its switchID, find itself inside the switchList which
	 * will need a for loop through the switch list which size is 1000 and add one connection count.
	 * At last, return the maximum count Switch
	 * The runtime complexity of the method would be: O(n+m*1000*constant) => O(n)
	 *
	 * @param startTime Start of time period.
	 * @param endTime End of time period.
	 * @return maxConnection count's switch ID
	 */
	@Override
	public int maxConnections(LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberList2();
		switchesList=dataReader.getSwitchList();
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





	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 *  5. combineLinkList()			Runtime Complexity: O(1);
	 *  6. getCapacity()				Runtime Complexity: O(1);
	 *  7. addCount()					Runtime Complexity: O(1);
	 *
	 * Initially, it will loop through the call record linked list and the methods inside the loop would execute
	 * n(LinkedList<CallPair> size) times. During each iteration, it would connection the current
	 * linkedList(connectionPath) behind the previous linkedList. As a result, all the connectionPath would be integrate
	 * into one big linkedList. Then, another for loop which size is m(LinkedList<Integer> size) would be called to loop
	 * through the big connectionPath linkedList and according to its switchID, find itself inside the switchList which
	 * will need a for loop through the switch list which size is 1000 and add one connection count.
	 * At last, return the minimum count Switch
	 * The runtime complexity of the method would be: O(n+m*1000*constant+1000*constant) => O(n)
	 *
	 * @return minConnection count's switch ID
	 */
	@Override
	public int minConnections() {
		phoneNumberPairList=dataReader.getphoneNumberList2();
		switchesList=dataReader.getSwitchList();
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

	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 *  5. isInTime()					Runtime Complexity:	O(1);
	 *  6. combineLinkList()			Runtime Complexity: O(1);
	 *  7. getCapacity()				Runtime Complexity: O(1);
	 *  8. addCount()					Runtime Complexity: O(1);
	 *
	 * Initially, it will loop through the call record linked list and the methods inside the loop would execute
	 * n(LinkedList<CallPair> size) times. During each iteration, it would connection the current
	 * linkedList(connectionPath) behind the previous linkedList. As a result, all the connectionPath would be integrate
	 * into one big linkedList. Then, another for loop which size is m(LinkedList<Integer> size) would be called to loop
	 * through the big connectionPath linkedList and according to its switchID, find itself inside the switchList which
	 * will need a for loop through the switch list which size is 1000 and add one connection count.
	 * At last, return the minimum count Switch
	 * The runtime complexity of the method would be: O(n+m*1000*constant+1000*constant) => O(n)
	 *
	 * @param startTime Start of time period.
	 * @param endTime End of time period.
	 * @return minConnection count's switch ID
	 */
	@Override
	public int minConnections(LocalDateTime startTime, LocalDateTime endTime) {
		phoneNumberPairList=dataReader.getphoneNumberList2();
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

	/**
	 * Runtime Complexity of used method:
	 * 	1. getphoneNumberLinkedList() 	Runtime Complexity: O(1);
	 * 	2. getSize()					Runtime Complexity: O(1);
	 *  3. reverseHead() 				Runtime Complexity: O(1);
	 * 	4. getElement()					Runtime Complexity: O(1);
	 * 	5. isIntime()					Runtime Complexity: O(1);
	 * 	6. getConnectionPath()			Runtime Complexity: O(1);
	 *
	 * 	In the first for loop, all the method inside of the list would be executed n(linkedlist<CallRecord> size) times.
	 * 	Additionally, inside the first for loop, another for loop has been used to loop through the connection Path
	 * 	and the method inside would executed for m(linkedList<Integer> size) times.
	 * 	Thus, the runtime complexity of the method is ：O(m*n) => O(n^2)
	 *
	 * @param startTime Start of time period.
	 * @param endTime End of time period.
	 * @return List<CallRecord>
	 */
	@Override
	public List<CallRecord> callsMade(LocalDateTime startTime, LocalDateTime endTime) {
		List<CallRecord> callRecords=new ArrayList<>();
		phoneNumberPairList=dataReader.getphoneNumberList2();
		for(int i=0;i<phoneNumberPairList.getSize();i++){
			CallPair callpair=phoneNumberPairList.reverseHead().getElement();
			List<Integer> connectionPath=new ArrayList<Integer>();
			if(callpair.isIntime(startTime, endTime)){
				for(int j=0;j<callpair.getConnectionPath().getSize();j++){
					if(callpair.getConnectionPath().getSize()!=0){
						connectionPath.add((callpair.getConnectionPath().reverseHead().getElement()));
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
		LocalDateTime endTime=LocalDateTime.parse("2017-09-21T19:37:30.455");
		LocalDateTime startTime=LocalDateTime.parse("2017-09-01T19:37:30.455");

		long number=3742128469L;
		//test.called(number);
		//System.out.println(test.callers(number));
		//System.out.println(test.callers(number));
		//System.out.println(test.findConnectionFault(number).size());
		//System.out.print(test.minConnections());
		//System.out.println("AutoTester Stub");
	}
	
	/**
	 * method that used to determine whether given callpair is fault or not
	 * 
	 * Created a new instance of Arraylist. Thus the space usage complexity is O(n)
	 * 
	 * Runtime Complexity:			O(1)
	 * Space usage Complexity:		O(n)
	 * @param callpair
	 * @return
	 */
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