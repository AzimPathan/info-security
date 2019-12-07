import java.util.*;
class VigenereDe
{
	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		System.out.println("Press 1 to encrypt a message or Press 2 to decrypt a message");
		int input = in.nextInt();
		if (input == 1) 
		{
			System.out.print("Enter the key in UPPER Case: ");
			String key = in.next();
			System.out.print("Enter message to encrypt: ");
			String emsg = in.next();
			String encryptMessage = encrypt(emsg, key);
			System.out.println("The encrypted message is: " + encryptMessage);
		}
		else if (input == 2) 
		{
			System.out.print("Enter the key in UPPER Case: ");
			String key = in.next();
			System.out.print("Enter message  to decrypt: ");
			String dmsg = in.next();
			String decryptMessage = decrypt(dmsg, key);
			System.out.println("The decrypted message is: " + decryptMessage);
		}
		else {
			System.out.println("Invalid Input");
		}
		
	}

	
	public static String encrypt(String Message, String Key) {
		String emsg= "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) 
			{
			char l = Message.charAt(i);
			emsg += (char)(((l - 65) + (Key.charAt(j)-65)) % 26 + 65);
			j = ++j % Key.length();
		}
		return emsg;
	}

	
	public static String decrypt(String Message, String Key) {
		String dmsg = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char l = Message.charAt(i);
			dmsg += (char)((l - Key.charAt(j) + 26) % 26 + 65);
			j = ++j % Key.length();
		}
		return dmsg;
	}

}