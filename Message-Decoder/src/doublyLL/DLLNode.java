/**********************************************************************************
* Project: DLLNode Class
* Assignment: Assignment 2
* Author(s): Aline Neves Alencar, 
* 			 Navid Ghasemnejadnaybin,
* 			 Rafael Sanches Carvalho.
* Student Number: 101036808,
* 				  101020678,
* 				  101004970.
* Date: March 27th, 2017
* Description: This .java file contains the DLLNode class. This class holds 
* 				the information particular to one node only. Every node contains 
* 				references to the node before and the node after, as well as holds 
* 				an integer for the packetID and a string for the message content.
*********************************************************************************/

package doublyLL;

public class DLLNode{

	private DLLNode prev;
	private DLLNode next;
	private int packetID;
	private String packetContent;
	
	public DLLNode(int packetID, String packetContent, DLLNode prev, DLLNode next) {
		this.packetID = packetID;
		this.packetContent = packetContent;
		this.setPrevNode(prev);
		this.setNextNode(next);
	}

	public DLLNode getPrevNode() 
	// Get the previous node
	{
		return prev;
	}

	public void setPrevNode(DLLNode prev) 
	// Set the previous node
	{
		this.prev = prev;
	}
	
	public DLLNode getNextNode() 
	// Get the next node
	{
		return next;
	}
	
	public void setNextNode(DLLNode next) 
	// Set the next node
	{
		this.next = next;
	}
	
	public int getPacketId() 
	// Get the packet ID
	{
		return packetID;
	}

	public String getPacketContent() 
	// Get the packet text
	{
		return packetContent;
	}
	
}
