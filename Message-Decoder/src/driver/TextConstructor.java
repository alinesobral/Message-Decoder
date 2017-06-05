/**********************************************************************************
* Project: TextConstructor class
* Assignment: Assignment 2
* Author(s): Aline Neves Alencar, 
* 			 Navid Ghasemnejadnaybin,
* 			 Rafael Sanches Carvalho.
* Student Number: 101036808,
* 				  101020678,
* 				  101004970.
* Date: March 27th, 2017
* Description: This .java file contains the TextConstructor class. This driver method
* 				in this class creates the doubly linked list from a text file passed
* 				as an argument and prints a scrambled message in the right order.
*********************************************************************************/

package driver;

import java.io.IOException;
import doublyLL.DLL;

public class TextConstructor {

	public static void main(String[] args) {
		try {
			DLL myMessage = new DLL();
			// Build the doubly linked list that contains the message
			myMessage.readAndConstruct("message.txt");
			// Print the message
			myMessage.printContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
