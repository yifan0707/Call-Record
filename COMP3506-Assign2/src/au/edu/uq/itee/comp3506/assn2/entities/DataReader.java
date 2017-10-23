package au.edu.uq.itee.comp3506.assn2.entities;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * the main purpose of this class is to read the data from the  file and store data using constructed data structure
 *
 * the class initiated two linked list as length of n,m which will take up to O(n*m) => O(n^2) space.
 * While the runtime complexity of the class would be O(n^2) as there are two method used to reading and storing the
 * file data from the given txt file
 *
 * The runtime Complexity: O(n^2)
 * The space usage Complexity: O(n^2)
 *
 */
public class DataReader {
	//scanners for switches, callRecordFile, callRecordShortFile
	private Scanner switches;
	private Scanner callRecords;
	private Scanner callRecordsShort;
	//scanners for each line
	private Scanner lineScanner;
	//LinkedList that contains all the call Record
	private LinkedList<CallPair> phoneNumberList;
	private LinkedList<CallPair> phoneNumberList2;
	//linkedList that contains all the switchID
	private SwitchList switchList;

	/**
	 * method that open file
	 * Space usage Complexity: 		O(1)
	 * Runtime Complexity:			O(1)
	 * @throws IOException
	 */
	public void openFile() throws IOException {
		phoneNumberList = new LinkedList<>();
		phoneNumberList2 = new LinkedList<>();
		try {
			switches = new Scanner(new File("COMP3506-Assign2/data/switches.txt"));
			callRecords = new Scanner(new File("COMP3506-Assign2/data/call-records.txt"));
			callRecordsShort = new Scanner(new File("COMP3506-Assign2/data/call-records-short.txt"));
		} catch (Exception e) {
			throw new IOException("File does not found!");
		}
	}

	/**
	 * the class initiated the new linked list which length is 1000 which take constant space.
	 * and a while loop has been used to store data into the linked list which will run 1000 times
	 * Space usage Complexity: 		O(1)
	 * Runtime Complexity:			O(1)
	 */
	public void readSwitchesFile(){
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
	}

	/**
	 * Space Complexity:
	 * 	1. hasNextLine()			O(1)
	 * 	2. nextLine()				O(1)
	 * 	3. hasNextLong()			O(1)
	 * 	4. intValue()				O(1)
	 * 	5. addLast()				O(1)
	 * 	6. setCaller()				O(1)
	 * 	7. getCaller()				O(1)
	 * 	8. setReceiver()			O(1)
	 * 	9. setCallerSwitch()		O(1)
	 * 	10. setReceiverSwitch()		O(1)
	 * 	11. setConnectionPath()		O(1)
	 * 	12. isValid() 				O(1)
	 * 	13. removeTail()			O(1)
	 * 	14. removeHead()			O(1)
	 *
	 * Runtime Complexity:
	 * 	1. hasNextLine()			O(1)
	 * 	2. nextLine()				O(1)
	 * 	3. hasNextLong()			O(1)
	 * 	4. intValue()				O(1)
	 * 	5. addLast()				O(1)
	 * 	6. setCaller()				O(1)
	 * 	7. getCaller()				O(1)
	 * 	8. setReceiver()			O(1)
	 * 	9. setCallerSwitch()		O(1)
	 * 	10. setReceiverSwitch()		O(1)
	 * 	11. setConnectionPath()		O(1)
	 * 	12. isValid() 				O(1)
	 * 	13. removeTail()			O(n)
	 * 	14. removeHead()			O(1)
	 *
	 * two while loop has been used to read all the data from the file which will iterate n(file lines count) times and
	 * m(line tokens count) times. RemoveTail() method's runtime complexity is O(b) (b is the size of the linkedlist)
	 * in worst case
	 * Space usage Complexity: 		O(m*n) => O(n^2)
	 * Runtime Complexity:			O(n*m+b) => O(n^2)
	 */
	public void readRecordFile(){
		int lineNumber=0;
		//loop through every line
		while(callRecords.hasNextLine()){
			lineNumber+=1;
			int tokenNumber=0;
			String record=callRecords.nextLine();
			lineScanner=new Scanner(record);
			//initialise a connectionPath that contains CallerSwitch& ReceiverSwitch
			LinkedList<Integer> connectionPath=new LinkedList<Integer>();
			//initialise a callPair with its lineNumber
			CallPair callPair=new CallPair(lineNumber);

			//info before time stamp
			while(lineScanner.hasNextLong()){
				tokenNumber+=1;
				Long nextLong=lineScanner.nextLong();
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
				try{
					LocalDateTime time = LocalDateTime.parse(timeStamp);
					if(time.getYear()==2017){
						if(time.getMonth().toString().equals("SEPTEMBER")){
							if(time.getDayOfMonth()>=1&&time.getDayOfMonth()<=21){
								callPair.setTimeStamp(time);
							}
						}
					}else{
						break;
					}
				}catch (DateTimeParseException e){
					e.printStackTrace();
					break;
				}
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
				if(isValid(callPair)){
					phoneNumberList2.addLast(new Node(callPair));
				}
			}
		}
	}

	/**
	 * Space Complexity:
	 * 	1. hasNextLine()			O(1)
	 * 	2. nextLine()				O(1)
	 * 	3. hasNextLong()			O(1)
	 * 	4. intValue()				O(1)
	 * 	5. addLast()				O(1)
	 * 	6. setCaller()				O(1)
	 * 	7. getCaller()				O(1)
	 * 	8. setReceiver()			O(1)
	 * 	9. setCallerSwitch()		O(1)
	 * 	10. setReceiverSwitch()		O(1)
	 * 	11. setConnectionPath()		O(1)
	 * 	12. isValid() 				O(1)
	 *
	 * Runtime Complexity:
	 * 	1. hasNextLine()			O(1)
	 * 	2. nextLine()				O(1)
	 * 	3. hasNextLong()			O(1)
	 * 	4. intValue()				O(1)
	 * 	5. addLast()				O(1)
	 * 	6. setCaller()				O(1)
	 * 	7. getCaller()				O(1)
	 * 	8. setReceiver()			O(1)
	 * 	9. setCallerSwitch()		O(1)
	 * 	10. setReceiverSwitch()		O(1)
	 * 	11. setConnectionPath()		O(1)
	 * 	12. isValid() 				O(1)
	 *
	 * two while loop has been used to read all the data from the file which will iterate n(file lines count) times and
	 * m(line tokens count) times.
	 * Space usage Complexity: 		O(m*n) => O(n^2)
	 * Runtime Complexity:			O(n*m) => O(n^2)
	 */
	public void readShortRecordsFile(){
		int lineNumber=0;
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
			if(tokenNumber>3){
				/*Remove the CallerSwitch and ReceiveSwitch from connectionPath
				 *and store the data into callPair 
				*/
				callPair.setCallerSwitch((Integer)connectionPath.removeHead().getElement());
				callPair.setReceiverSwitch((Integer)connectionPath.removeTail().getElement());
				callPair.setConnectionPath(connectionPath);
				if(isValid(callPair)){
					phoneNumberList.addLast(new Node(callPair));
				}
			}
		}
	}

	/**
	 * method used to close all file
	 * Space usage Complexity: 		O(1)
	 * Runtime Complexity:			O(1)
	 * @return	the data read from call-records-short
	 */
	public void closeFile(){
		switches.close();
		callRecords.close();
		callRecordsShort.close();
	}

	/**
	 * get method of phoneNumberLinkedList
	 * Space usage Complexity: 		O(1)
	 * Runtime Complexity:			O(1)
	 * @return	the data read from call-records-short
	 */
	public LinkedList<CallPair> getphoneNumberLinkedList(){
		return phoneNumberList;
	}

	/**
	 * get method of phoneNumberLinkedList2
	 * Space usage Complexity: 		O(1)
	 * Runtime Complexity:			O(1)
	 * @return	the data read from call-records
	 */
	public LinkedList<CallPair> getphoneNumberList2() {
		return phoneNumberList2;
	}

	/**
	 * get method of the switchList
	 * Space usage Complexity: 		O(1)
	 * Runtime Complexity:			O(1)
	 * @return switchList
	 */
	public SwitchList getSwitchList() {
		return switchList;
	}

	/**
	 * method that used to check whether the callpair is faulty
	 * Space usage Complexity: 		O(n)
	 * Runtime Complexity:			O(1)
	 * @param callpair
	 * @return
	 */
	public boolean isValid(CallPair callpair){
		LinkedList<Integer> connectionPath=callpair.getConnectionPath();
		int callerSwitch=callpair.getCallerSwitch();
		if(connectionPath.getSize()>0){
			//First node in connection path is not the same with callerSwitchID
			if(callerSwitch!=(int)connectionPath.getHead().getElement()||callpair.getTimeStamp()==null){
				return false;
			}
		}
		return true;
	}
}
