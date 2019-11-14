import java.util.*;
class vigenere_cipher
{
	public static String encrypt(String Message, String Key) {
		String emsg= "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) 
		{
			char ch = Message.charAt(i);
			emsg += (char)(((ch - 65) + (Key.charAt(j)-65)) % 26 + 65);
			j = ++j % Key.length();
		}
		return emsg;
	}

	public static String decrypt(String Message, String Key) {
		String dmsg = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++)
		{
			char ch = Message.charAt(i);
			dmsg += (char)((ch - Key.charAt(j) + 26) % 26 + 65);
			j = ++j % Key.length();
		}
		return dmsg;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int opt;
		do
		{
			System.out.print("Choose option\n1. Encrypt a message\n2. Decrypt a message\n3. Exit\nOption : ");
			opt= in.nextInt();
			if (opt == 1) 
			{
				System.out.print("Enter the key in UPPER Case: ");
				String key = in.next();
				in.
				System.out.print("Enter message to encrypt: ");
				String emsg = in.nextLine();
				String encryptedMessage = encrypt(emsg, key);
				System.out.println("Encrypted message : " + encryptedMessage);
			}
			else if (opt == 2) 
			{
				System.out.print("Enter the key in UPPER Case: ");
				String key = in.next();
				in.skip('\n');
				System.out.print("Enter message  to decrypt: ");
				String dmsg = in.next();
				String decryptedMessage = decrypt(dmsg, key);
				System.out.println("Decrypted message is: " + decryptedMessage);
			}
			else if(opt==3)
				break;
			else
				System.out.println("Invalid option!");
		}while(opt!=3);
	}
}