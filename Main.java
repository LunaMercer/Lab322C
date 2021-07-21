//Precondition: Number inserted into array mus be >=1 and <16
//Currency values must not have 3 decimals
//Postconditions: Each value inserted into array will be sorted from smallest to biggest, after being compared and contrast
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
	/**
	 * Helper function to print currency in the array
	 * @param args
	 */
	static void printCurrency(Currency arr[]){
		for(Currency c : arr){
			c.printCurrency();
			System.out.println();
		}
	}
	/**
	 * Insertion sort using recursion
	 * @param arr - Array of currency
	 * @param size - Size of the array
	 */
	static void RecurInSort(Currency arr[], int size){
		//if size is less than or equal to 1, no need to sort the array
		if(size <= 1)
			return;
		//Sort n - 1 elements recursively
		RecurInSort(arr, size - 1);
		
		//Print the elements for iteration
		System.out.println("\nNext Iteration: ");
		printCurrency(arr);
		
		//Store the last element in the temp element
		Currency last = arr[size - 1];
		int index = size - 2;
		
		//place the last element in the correct place
		while(index >= 0 && arr[index].compareCurrency(last) == 1){
			arr[index + 1] = arr[index];
			index --;
		}
		arr[index + 1] = last;
	}
	
	/**
	 * Write the currency array into file
	 * @param arr
	 */
	public static void writeFile(Currency arr[]){
		try{
			FileWriter myWriter = new FileWriter("output.txt");
			for(Currency c : arr){
				myWriter.write(c.toString() + "\n");
			}
			myWriter.close();
		} catch(IOException e){
			System.out.println("An error occured when writing to output file ");
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		//Ask the user for number of elements
		System.out.print("Enter the number of elements: ");
		int size = scanner.nextInt();
		scanner.nextLine();
		//get the input until it is valid
		while(size <= 0 || size > 16){
			System.out.println("Please enter a valid number between 1 and 16");
			System.out.println("Enter the number of elements:");
			size = scanner.nextInt();
			scanner.nextLine();
		}
		
		//Create currency objects
		Currency[] currencies = new Currency[size];
		
		//iterate to get 5 currencies
		for(int currencyItem = 0; currencyItem < size; currencyItem++){
			System.out.print("Enter currency" + (currencyItem + 1)+ "value:");
			String val = scanner.nextLine();
			//split the string to notes and coins
			int noteValue = Integer.valueOf(val.split("\\.")[0]);
			int coinValue = Integer.valueOf(val.split("\\.")[1]);
			//check if coin value is less than 10, multiply the coin value by 10
			if(coinValue<10){
				coinValue *= 10;
			}
			//create money instance
			currencies[currencyItem] = new Money(noteValue,coinValue);
		}
		
		System.out.println("\n***** List of Money Objects created*****");
		
		//Iterate through the currencies
		for(Currency currency : currencies){
			//print the currency
			currency.printCurrency();
			System.out.println();
		}
		
		System.out.println("\nCalling RecurInSort:");
		RecurInSort(currencies,size);
		
		System.out.println("\nSorted Array:");
		printCurrency(currencies);
		
		//write into file
		writeFile(currencies);
		
		scanner.close();
	}
}
