import java.util.ArrayList;
import java.util.Arrays;
// Linear Probing and Double Hashing
public class HashFunction {

	// Properties defined
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	// A constructor with single parameter
	HashFunction(int size) {
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray, "-1");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create the hash table with size of 30 empty values (indicated with -1s)
		HashFunction theFunc = new HashFunction(31);
		// remember no duplicates
//		String[] elementsToAdd = {"1", "5", "17", "21", "26"};
//		theFunc.hashFunction1(elementsToAdd, theFunc.theArray);
//		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
//				                "235", "802", "900", "723", "699", "1", "16", "999", "890",
//				                "725", "998", "978", "988", "990", "989", "984", "320", "321",
//				                "400", "415", "450", "50", "660", "624" };

//		theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
//		theFunc.findKey("660");
		
		// Demonstrate how data normally follows patterns and how
        // a non-prime sized array can cause havoc, with multiples of 30
        String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        theFunc.hashFunction2(elementsToAdd3, theFunc.theArray);
        theFunc.increaseArraySize(60);
		theFunc.displayTheStack();
		
		theFunc.fillArrayWithNeg1();
		
		theFunc.doubleHashFunc(elementsToAdd3, theFunc.theArray);
		theFunc.displayTheStack();
		theFunc.findKeyDblHashed("989");
	}

	// Methods
	public void hashFunction1(String[] stringsForArray, String[] theArray) {
		for(int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];
			theArray[Integer.parseInt(newElementVal)] = newElementVal;
		}
	}
	
	// A positive integer greater than 1 which has no other factors except 1 and the number itself is called a prime number.
	public boolean isPrime(int number) {
		// if got a whole number, it is not a prime
		if(number % 2 == 0)
			return false;
		// check all the odd numbers after 2
		for(int i = 3; i * i <= number; i+=2) {
			if(number % i == 0)
				return false;
		}
		// If we make it here we know it is odd

		return true;
	}
	
	public int getNextPrime(int minNumberToCheck) {
		// Cycle through this for as long as it takes to find a prime
		for(int i = minNumberToCheck; true; i++) {
			if(isPrime(i))
				return i;
			// If it is not a prime, continue to cycle forever until I find a prime number
		}
	}
	
	public void increaseArraySize(int minArraySize) {
		// Get a prime number that's bigger than the array that is requested
		// NOTE: It is guaranteed to return a higher prime number
		int newArraySize = getNextPrime(minArraySize);
		
		// Move the array into a bigger array with the larger prime size
		moveOldArray(newArraySize);
	}
	
	public void moveOldArray(int newArraySize) {
		String[] cleanArray = removeEmptySpacesInArray(theArray);
		
		theArray = new String[newArraySize];
		
		arraySize = newArraySize;
		
		fillArrayWithNeg1();
		
		hashFunction2(cleanArray, theArray);
	}
	
	public String[] removeEmptySpacesInArray(String[] arrayToClean) {
		// Temporary holding cell
		ArrayList<String> stringList = new ArrayList<String>();
		
		// Enhanced for loop
		for(String theString : arrayToClean) {
			if(!theString.equals("-1") && !theString.equals(""))
				stringList.add(theString);
		}
		return stringList.toArray(new String[stringList.size()]);
	}
	
	public void fillArrayWithNeg1() {
		Arrays.fill(theArray, "-1");
	}
	
	// Insertion with linear probing
	public void hashFunction2(String[] stringsForArray, String[] theArray) {
		for(int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];
			int arrayIndex = Integer.parseInt(newElementVal) % 29;
			System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);
			while(theArray[arrayIndex] != "-1") {
				++arrayIndex;	// increment by 1
				System.out.println("Collision Try " + arrayIndex + " Instead");
				
				// If we get to the end of the array, we want to cycle back the index
				arrayIndex %= arraySize;
			}
			theArray[arrayIndex] = newElementVal;
		}
	}
	
	public String findKey(String key) {
		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % arraySize;
		// while not empty
		while(theArray[arrayIndexHash] != "-1") {
			if(theArray[arrayIndexHash] == key) {
				System.out.println(key + " was Found in Index " + arrayIndexHash);
				return theArray[arrayIndexHash];
			}
			++arrayIndexHash;
			
			arrayIndexHash %= arraySize;
		}
		
		return null;	// means couldn't find it
	}
	
	// Insertion with double hashing
		public void doubleHashFunc(String[] stringsForArray, String[] theArray) {
			for(int n = 0; n < stringsForArray.length; n++) {
				String newElementVal = stringsForArray[n];
				int arrayIndex = Integer.parseInt(newElementVal) % arraySize;
				
				// Change the step distance down in other indexes than just picking the next index
				int stepDistance = 5 - (Integer.parseInt(newElementVal) % 5);
				System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);
				
				// Cycle through the array until we find an empty space
				while(theArray[arrayIndex] != "-1") {
					arrayIndex += stepDistance;	// increment by stepDistance
					System.out.println("Collision Try " + arrayIndex + " Instead");
					
					// If we get to the end of the array, we want to cycle/go back to index 0
					arrayIndex %= arraySize; // arrayIndex = arrayIndex % arraySize;
				}
				theArray[arrayIndex] = newElementVal;
			}
		}
	
	
	public String findKeyDblHashed(String key) {
		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % arraySize;
		
		int stepDistance = 5 - (Integer.parseInt(key) % 5);
		
		// while not empty
		while(theArray[arrayIndexHash] != "-1") {
			if(theArray[arrayIndexHash] == key) {
				System.out.println(key + " was Found in Index " + arrayIndexHash);
				return theArray[arrayIndexHash];
			}
			
			arrayIndexHash += stepDistance;
			
			arrayIndexHash %= arraySize;
		}
		
		return null;	// means couldn't find it
	}
	public void displayTheStack() {
		int increment = 0;
		int numberOfRows = (arraySize / 10) + 1;

        for (int m = 0; m < numberOfRows; m++) {
            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");
 
            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");	// end of line

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
            	if (n >= arraySize)		// To prevent out of bounds
            		System.out.print("|      ");
            	else if (theArray[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out
                            .print(String.format("| %3s " + " ", theArray[n]));
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
        }
	}
}
