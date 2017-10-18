package au.edu.uq.itee.comp3506.assn2.tests;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import au.edu.uq.itee.comp3506.assn2.api.TestAPI;
import au.edu.uq.itee.comp3506.assn2.entities.CallRecord;
import au.edu.uq.itee.comp3506.assn2.entities.DataReader;
import au.edu.uq.itee.comp3506.assn2.entities.LinkedList;
import au.edu.uq.itee.comp3506.assn2.entities.PhoneNumber;

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
	LinkedList<PhoneNumber> phoneNumberPairList;
	PhoneNumber phoneNumber;
	int[] switchesList;
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
			PhoneNumber element=(PhoneNumber)phoneNumberPairList.reverseHead().getElement();
				if(element.getCaller()==dialler){
					receivers.add(element.getReceiver());
			}
		}
		return receivers;
	}

	@Override
	public List<Long> called(long dialler, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> callers(long receiver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> callers(long receiver, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findConnectionFault(long dialler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findConnectionFault(long dialler, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findReceivingFault(long reciever) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findReceivingFault(long reciever, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int maxConnections() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxConnections(LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minConnections() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minConnections(LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CallRecord> callsMade(LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		AutoTester test = new AutoTester();
		long number=3742128469L;
		test.called(number);
		System.out.println("AutoTester Stub");
	}
}