/*****************************************
 *		file: CoinDispenser
 *		author: Cameron Edmondson
 *		class: CS 240 - Data Structures and Algorithms
 *
 *		assignment: 1
 *		date last modified: 4/10/2017
 *
 *		purpose: This program takes input from the user in dollars or cents
 *				 and dispenses the given amount in quarters, dimes, nickels, and pennies.
 *		 
 *	
 *****************************************/

import java.util.Scanner;

// Begin class method
public class CoinDispenser {

	// Begin main method
	public static void main(String[] args) {

		// Declare and initialize array to four elements
		int[] coinCount = new int[4];

		// Create input object
		Scanner input = new Scanner(System.in);

		// Declare and initialize variables
		String text;
		double amountInput = 0.0;
		long amount = 0;

		// Enter try catch block
		try {
			do {
				// Prompt user
				System.out.print("Enter amount to dispense or 'done' to quit: ");
				text = input.next();

				// If input is not equal to 'done'
				if (!text.equalsIgnoreCase("done")) {

					amountInput = Double.parseDouble(text);
					// Multiply amount by 100 to get rid of decimal and store in
					// amount variable
					amount = (long) (amountInput * 100);
				}

				// Continue while amount is not equal to zero
				while (amount != 0) {
					// If amount is divisible by 25 subtract 25 from amount and increment coinCount by 1
					if (amount % 25 == 0) {
						amount = amount - 25;
						coinCount[0]++;
					} 
					// If amount is divisible by by 25 but has a remainder less than 25
					else if (amount % 25 != 0 && amount > 25) { 
						amount = amount - 25;
						coinCount[0]++;
					} 
					// If amount is divisible by 10 subtract 10 from amount and increment coinCount by 1
					else if (amount % 10 == 0) {
						amount = amount - 10;
						coinCount[1]++;
					} 
					// If amount is divisible by 5 subtract 5 from amount and increment coinCount by 1
					else if (amount % 5 == 0) {
						amount = amount - 5;
						coinCount[2]++;
					} 
					// If amount is divisible by 1 subtract 1 from amount and increment coinCount by 1
					else if (amount % 1 == 0) {
						amount = amount - 1;
						coinCount[3]++;
					}
				}
			} while (!text.equalsIgnoreCase("done")); // Continue while text is not equal to 'done'

			// Print coins to console
			System.out.println("Quarters: " + coinCount[0] + "\nDimes: " + coinCount[1] + "\nNickles: " + coinCount[2]
					+ "\nPennies: " + coinCount[3]);

		} // Catch wrong format 
		catch (NumberFormatException e) {
			System.out.println("Invalid input! Try again: ");
		}

		input.close(); // Close scanner object

	}// End main method

}// End class method
