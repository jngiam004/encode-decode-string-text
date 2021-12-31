import java.util.Scanner;

public class Hello {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 1;
		while(choice == 1)
		{
		String originalStr = "HELLO WORLD";
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter a character: ");
	    char c = scanner.next().charAt(0);
	    System.out.println("You have entered: "+ c);
		// offset character is the key
		int offsetChar = 0;
		char prependChar = c;
		// Create and instantiate a new object
		Hello example = new Hello();
		
		char[] referenceTableArray = new char[44];//declaration 
		char[] reshuffleTableArray = new char[44];//declaration 
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
		
		
		String format1 = "%-25s%s%n";
		String format2 = "%-25s%c%s%n";
		System.out.printf(format1, "Original Plaintext : ", originalStr);
		
		// Process the input
		String encodedStr = example.encode(originalStr, referenceTableArray, reshuffleTableArray, offsetChar, prependChar);
		String decodedStr = example.decode(encodedStr, referenceTableArray, reshuffleTableArray);
		
		// Display output
		System.out.printf(format2, "Encoded String : ", prependChar, encodedStr);
		System.out.printf(format1, "Decoded String : ", decodedStr);
		System.out.println();
		System.out.println("Would you like to continue?");
		System.out.println("Press 1 for Yes");
		System.out.println("Press 0 for No");
		choice = scanner.nextInt();
		System.out.println("=================================================================");
		if (choice == 0)
		{
			System.out.println("\nProgram Exited");
		}
		}
	}
	// Convert plaintext to obfuscated string (encrypted message)
	public static String encode (String plainText, char[] referenceTableArray, char[] reshuffleTableArray, int offsetChar, char prependChar) {
		char[] chars = plainText.toCharArray();
		System.out.print("referenceTableArray: ");
		for (int i = 0; i < referenceTableArray.length; i++) {
			System.out.print(referenceTableArray[i]);
			if (referenceTableArray[i] == prependChar)
			{
				offsetChar = i;
			}
		}
		
		int newindex = 0;
		for (int j = referenceTableArray.length-offsetChar; j < referenceTableArray.length; j++) {
			reshuffleTableArray[newindex] = referenceTableArray[j];
			newindex++;
		}
		System.out.println();	
		for (int k = 0; k < referenceTableArray.length-offsetChar; k++) {
			reshuffleTableArray[newindex] = referenceTableArray[k];
			newindex++;
		}
		System.out.print("reshuffleTableArray: ");
		for (int i = 0; i < reshuffleTableArray.length; i++) {
			System.out.print(reshuffleTableArray[i]);
		}
		System.out.println();	
		String encoded = "";
			for(char c: chars) {
				if (c == ' ')
				{
					encoded += ' ';
				}
				else 
				{
					for (int l = 0; l < referenceTableArray.length; l ++) {
						if (c == referenceTableArray[l])
						{
							encoded += reshuffleTableArray[l];
							break;
						}
					}
				}	
			}
		
		return new String(encoded);
	}
	// Convert obfuscated string to plaintext (decrypted message)
	public static String decode (String encodedText, char[] referenceTableArray, char[] reshuffleTableArray) {
		char[] chars = encodedText.toCharArray();
		String decoded = "";
	
		for(char c: chars) {
			if (c == ' ')
			{
				decoded += ' ';
			}
			else
			{
				for (int l = 0; l < reshuffleTableArray.length; l ++) {
					if (c == reshuffleTableArray[l])
					{
						decoded += referenceTableArray[l];
						break;
					}
				}
			}	
		}
		return new String(decoded);
	}
	
}
