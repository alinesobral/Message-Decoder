/**********************************************************************************
* Project: DLL Class
* Assignment: Assignment 2
* Author(s): Aline Neves Alencar, 
* 			 Navid Ghasemnejadnaybin,
* 			 Rafael Sanches Carvalho.
* Student Number: 101036808,
* 				  101020678,
* 				  101004970.
* Date: March 27th, 2017
* Description: This .java file contains the DLL class. This class holds a reference 
* 				to the first node of a  sorted doubly linked list. It also reads 
* 				from a text file in order to build the list in a sorted manner.
*********************************************************************************/

package doublyLL;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class DLL {
	protected DLLNode list; // first node of the message
	
	public DLL()
	{
		list = null;
	}
	
	/** 
	 * This method reads a file passed into it, line by line, storing
	 * the content of each line in a string array.
	 * 
	 * @param sourceFile: input file with messages and packet IDs.
	 * @return void
	 * @throws IOException
	 */
	public void readAndConstruct(String sourceFile)
		throws IOException
	{
		try{
            BufferedReader scrambledText = new BufferedReader(new FileReader(sourceFile));
            String currLine = scrambledText.readLine();
            String[] wordsArray;

            while(currLine != null)
            {
                /* wordsArray is an array that holds two strings:
            	 * the packetID in index 0 and the packetContent in index 1 */
                wordsArray = currLine.split("\t");
                findPosition(wordsArray);
                currLine = scrambledText.readLine();
            }
            scrambledText.close();
        }
		catch(Exception e){
            e.printStackTrace();
        }
	}

	/**
	 * This method finds a position for the new packet in a list based on
	 * the packets' packetID, sorted in an ascending order.
	 * 
	 * @param packetInfo: String array that contains a packetID on index 0
	 * and a packetContent on index 1
	 * @return void
	 */
	protected void findPosition(String[] packetInfo)
	{
		int packetID = Integer.parseInt(packetInfo[0]);
		String packetContent = packetInfo[1];
		DLLNode nextNode = list;
		DLLNode prevNode = null;
		
		if(list != null)
		{
			//check if the current packet's id is less than or equal the id of the new packet
			while(nextNode != null && nextNode.getPacketId() < packetID)
			{
				prevNode = nextNode;
				nextNode = nextNode.getNextNode();
			}
			this.add(packetID, packetContent, prevNode, nextNode);
		}
		else
			this.add(packetID, packetContent, null, null);
	}
	
	/**
	 * This method creates the node with the packet information and adds it
	 * to the list.
	 * 
	 * @param packetID: integer that holds the id of the packet
	 * @param packetContent: string that holds the text of the packet
	 * @param prev: DLLNode node that is before the new node's position
	 * @param next: DLLNode node that is after the new node's position
	 * @return void
	 */
	public void add(int packetID, String packetContent, DLLNode prev, DLLNode next) {
		//add a node in the right place
		DLLNode newNode = new DLLNode(packetID, packetContent, prev, next);
		
		newNode.setPrevNode(prev);
		newNode.setNextNode(next);
		
		// If the new node is going to be the first on the list
		if(prev == null)
			list = newNode;
		
		if(prev != null)
			prev.setNextNode(newNode);
		
		if(next != null)
			next.setPrevNode(newNode);
	}
	
	/**
	 * This method prints the entire contents of its nodes to create
	 * 
	 * @param none
	 * @return void
	 */
	public void printContent()
	// Returns a nicely formatted string that represents this list.
	{
	 String listString = "Message:\n";
	 if (list != null)
	 {
	   DLLNode prevNode = list;
	   do
	   {
	     listString += prevNode.getPacketContent() + " ";
	     prevNode = prevNode.getNextNode();
	   }
	   while (prevNode != null);
	 } 
	 System.out.println(listString);
	}  

}
