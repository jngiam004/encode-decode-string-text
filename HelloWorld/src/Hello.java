import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 	
 * Any character ('#', '$', etc...) not in the reference table will mapped back to the same character 
 * including whitespace character (' ')
*/
public class Hello {
	
	static Character[] referenceTableArray = new Character[44];//declaration 
	static Character[] reshuffleTableArray = new Character[44];//declaration 
	static Character[] decodedTableArray = new Character[44];//declaration 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 1;
		while(choice == 1)
		{
			//String plainText = "HELLO WORLD";
			//String plainText = "ABC9&";
			String plainText = "H#LLO WORLD";
			
			Scanner scanner = new Scanner(System.in);
		    System.out.print("Enter a character: ");
		    char prependChar = scanner.next().trim().charAt(0);
		    
		    System.out.println("You have entered: "+ prependChar);
		    System.out.println();
		    
			System.out.printf("%-25s%s%n", "Original Plaintext: ", " " + plainText);
			plainText = prependChar + plainText;
			
			// Populate Reference Table
			constructReferenceTableArray();
			
			// Process the input
			String encodedText = encode(plainText);
			String decodedText = decode(encodedText);
			
			// Display output
			System.out.printf("%-25s%s%n", "Encoded String: ", encodedText);
			System.out.printf("%-25s%s%n", "Decoded String: ", decodedText);
			System.out.println();
			System.out.println("Would you like to continue?");
			System.out.println("1) Press 1 for Yes");
			System.out.println("2) Press 0 for No");
			choice = scanner.nextInt();
			
			System.out.println("=================================================================");
			if (choice == 0)
			{
				System.out.println("\nProgram Exited");
			}
		}
	}
	
	public static void constructReferenceTableArray() {
		//initialization (All unique characters)
		referenceTableArray[0]='A';
		referenceTableArray[1]='B';  
		referenceTableArray[2]='C'; 
		referenceTableArray[3]='D'; 
		referenceTableArray[4]='E'; 
		referenceTableArray[5]='F'; 
		referenceTableArray[6]='G'; 
		referenceTableArray[7]='H'; 
		referenceTableArray[8]='I'; 
		referenceTableArray[9]='J'; 
		referenceTableArray[10]='K'; 
		referenceTableArray[11]='L'; 
		referenceTableArray[12]='M'; 
		referenceTableArray[13]='N'; 
		referenceTableArray[14]='O'; 
		referenceTableArray[15]='P'; 
		referenceTableArray[16]='Q'; 
		referenceTableArray[17]='R'; 
		referenceTableArray[18]='S'; 
		referenceTableArray[19]='T'; 
		referenceTableArray[20]='U'; 
		referenceTableArray[21]='V'; 
		referenceTableArray[22]='W'; 
		referenceTableArray[23]='X'; 
		referenceTableArray[24]='Y'; 
		referenceTableArray[25]='Z'; 
		referenceTableArray[26]='0'; 
		referenceTableArray[27]='1'; 
		referenceTableArray[28]='2'; 
		referenceTableArray[29]='3'; 
		referenceTableArray[30]='4'; 
		referenceTableArray[31]='5'; 
		referenceTableArray[32]='6'; 
		referenceTableArray[33]='7'; 
		referenceTableArray[34]='8'; 
		referenceTableArray[35]='9'; 
		referenceTableArray[36]='('; 
		referenceTableArray[37]=')'; 
		referenceTableArray[38]='*'; 
		referenceTableArray[39]='+'; 
		referenceTableArray[40]=','; 
		referenceTableArray[41]='-'; 
		referenceTableArray[42]='.'; 
		referenceTableArray[43]='/'; 
	}
	
	// Convert plaintext to obfuscated string (encrypted message)
	public static String encode (String plainText) {
		int offsetChar = 0;						// offset character is the key
		char[] chars = plainText.toCharArray(); // Convert string to array of characters
		
		// Get the index of the offset character
		for (int i = 0; i < referenceTableArray.length; i++) {
			// When the offset character matches the character in reference table, get the offset number
			if (referenceTableArray[i] == chars[0])
			{
				offsetChar = i;
				break;
			}
		}
		
		// Partially insert characters based on the offset distance
		int newindex = 0;
		for (int j = referenceTableArray.length-offsetChar; j < referenceTableArray.length; j++) {
			reshuffleTableArray[newindex] = referenceTableArray[j];
			newindex++;
		}
		
		// Fully insert characters based on the remaining slots left off from the previous index
		for (int k = 0; k < referenceTableArray.length-offsetChar; k++) {
			reshuffleTableArray[newindex] = referenceTableArray[k];
			newindex++;
		}
		
		// Display Output
		String encoded = Character.toString(chars[0]);
		
		List<Character> referenceTableList = new ArrayList<>(Arrays.asList(referenceTableArray));
		
		// currentChar start from index 1 to skip the first character
		for(int currentChar = 1; currentChar < chars.length; currentChar++) {
			for (int l = 0; l < referenceTableList.size(); l ++) {
				if (referenceTableList.contains(chars[currentChar]))
				{
					if (chars[currentChar] == referenceTableList.get(l))
					{
						encoded += reshuffleTableArray[l];
						break;
					}
				}
				else
				{
					encoded += chars[currentChar];
					break;
				}
			}	
		}
	return encoded;
	}
	// Convert obfuscated string to plaintext (decrypted message)
	public static String decode (String encodedText) {
		int offsetChar = 0;						// offset character is the key
		String newEncodedText = encodedText.substring(1);		// Get all characters after the first character
		char[] chars = newEncodedText.toCharArray();
		
		// Get the index of the offset character
		for (int i = 0; i < referenceTableArray.length; i++) {
			// When the offset character matches the character in reference table, get the offset number
			if (referenceTableArray[i] == encodedText.charAt(0))
			{
				offsetChar = i;
				break;
			}
		}
		int newIndex = offsetChar;
		int remainingCounter = 0;
		// Partially insert characters based on the offset distance
		for (int j = 0; j < reshuffleTableArray.length; j++) {
			if (j < reshuffleTableArray.length - offsetChar )
			{
				decodedTableArray[j] = reshuffleTableArray[newIndex];
			}
			else
			{
				remainingCounter = j;
				break;
			}
			
			if(newIndex != reshuffleTableArray.length - 1)
				newIndex++;
		}
		
		// Fully insert characters based on the remaining slots left off from the previous index
		for (int k = 0; k < offsetChar; k++) {
			decodedTableArray[remainingCounter] = reshuffleTableArray[k];
			remainingCounter++;
		}

		String decoded = " ";
		List<Character> decodedTableList = new ArrayList<>(Arrays.asList(decodedTableArray));
		for(char currentChar: chars) {
			for (int l = 0; l < decodedTableList.size(); l ++) {
				if (decodedTableList.contains(currentChar))
				{
					if (currentChar == reshuffleTableArray[l])
					{
						decoded += decodedTableList.get(l);
						break;
					}
				}
				else
				{
					decoded += currentChar;
					break;
				}
			}		
		}
		return decoded;
	}
}
