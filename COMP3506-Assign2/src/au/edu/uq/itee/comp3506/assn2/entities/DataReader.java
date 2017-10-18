package au.edu.uq.itee.comp3506.assn2.entities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataReader {
	
	private Scanner switches;
	private Scanner callRecords;
	private Scanner callRecordsShort;
	private Scanner lineScanner;
	private LinkedList<PhoneNumber> phoneNumberList;
	
	int[] switchesID=new int[20];
	
	public void openFile() throws IOException{
		phoneNumberList=new LinkedList<PhoneNumber>();
		try{
			switches= new Scanner(new File("./data/switches.txt"));
			callRecords=new Scanner(new File("./data/call-records.txt"));
			callRecordsShort=new Scanner(new File("./data/call-records-short.txt"));
		}catch(Exception e){
			throw new IOException("File does not found!");
		}	
	}
	
	public int[] readSwitchesFile(){
		int number=0;
		if(switches.hasNextInt()){
			number= switches.nextInt();
		}
		int[] switchesList=new int[number];
		for(int i=0;i<number;i++){
			if(switches.hasNextInt()){
				switchesList[i]=switches.nextInt();
			}
		}
		return switchesList;
	}
	
	public void readRecordsFile(){
		while(callRecordsShort.hasNextLine()){
			PhoneNumber phoneNumber=new PhoneNumber();
			String record=callRecordsShort.nextLine();
			lineScanner=new Scanner(record);
			//info before time stamp
			while(lineScanner.hasNextLong()){
				Long nextLong=lineScanner.nextLong();
				if(nextLong<=100000&&nextLong>=10000){
					int nextInt=nextLong.intValue();
					for(int j=0;j<=10;j++){
						if(switchesID[j]==0){
							switchesID[j]=nextInt;
							System.out.println(switchesID[j]);
							break;
						}else{
							continue;
						}
					}
				}else if(nextLong>=1000000000){
					if(phoneNumber.getCaller()==0){
						phoneNumber.setCaller(nextLong);
					}else{
						phoneNumber.setReceiver(nextLong);
					}
				}
			}
			phoneNumberList.addLast(new Node(phoneNumber));
			//Node ha=new Node(phoneNumber);
			//System.out.println(ha.getElement().getReceiver()+"before");
			//System.out.println(ha.getElement().getReceiver()+"after");
		}
	}
	

	
	
	
	public void closeFile(){
		switches.close();
		callRecords.close();
		callRecordsShort.close();
	}
	
	public LinkedList<PhoneNumber> getphoneNumberLinkedList(){
		return phoneNumberList;
	}
}
