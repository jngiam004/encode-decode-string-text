import java.util.Scanner;

public class Encoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 1;
		while(choice == 1)
		{
			String originalStr = "HELLO WORLD";
			Scanner scanner = new Scanner(System.in);
		    System.out.print("Enter a character: ");
		    char prependChar = scanner.next().charAt(0);
		    System.out.println("You have entered: "+ prependChar);
			// offset character is the key
			int offsetChar = 0;
			char[] referenceTableArray = new char[44];//declaration 
	
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
			
			
//			String format1 = "%-25s%s%n";
//			String format2 = "%-25s%c%s%n";
//			System.out.printf(format1, "Original Plaintext : ", originalStr);
//			
//			// Process the input
//			String encodedStr = example.encode(originalStr, referenceTableArray, reshuffleTableArray, offsetChar, prependChar);
//			String decodedStr = example.decode(encodedStr, referenceTableArray, reshuffleTableArray);
//			
//			// Display output
//			System.out.printf(format2, "Encoded String : ", prependChar, encodedStr);
//			System.out.printf(format1, "Decoded String : ", decodedStr);
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

}
