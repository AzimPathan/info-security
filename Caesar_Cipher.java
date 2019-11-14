import java.util.*;
import java.io.*;

class Caesar_Cipher
{
	public static void main(String args[]) throws FileNotFoundException,IOException
	{
		Scanner sc=new Scanner(System.in);
		// Take the shift value and file name from command line
		int shift=Integer.parseInt(args[0]);
		// Read the input message from file
		File file=new File(args[1]);
		//System.out.print(args[1]);
		
		BufferedReader br=new BufferedReader(new FileReader(file));
		String msg="";
		int temp;
		char ch;
		System.out.print("Original Message : ");
		// Read the contents from file
		while((temp=br.read())!=-1)
		{
			//System.out.print(temp);
			ch=(char)temp;
			System.out.print(ch);
			// Only consider alphabets, ignore the digits and special characters
			if(temp>=65 && temp<=122)
				msg+=ch;
		}
		// Make string in uppercase
		msg=msg.toUpperCase();
		System.out.println("\nFormatted Message : "+msg);

		// Encrypt the data by constructing the cipher text
		String cipher_text="";
		int charValue;
		for(int i=0;i!=msg.length();i++)
		{
			// Handle greater characters
			if(msg.charAt(i)+shift>90)
				charValue=(msg.charAt(i)+shift)-26;
			else
				charValue=(msg.charAt(i)+shift);
			cipher_text+=(char)charValue;
		}
		System.out.println("Encrypted text : "+cipher_text);

		// Decrypt the data by constructing the plain text
		String plain_text="";
		for(int i=0;i!=cipher_text.length();i++)
		{
			// Handle lower characters
			if(cipher_text.charAt(i)-shift<65)
				charValue=(cipher_text.charAt(i)-shift)+26;
			else
				charValue=cipher_text.charAt(i)-shift;
			plain_text+=(char)charValue;
		}
		System.out.println("Decrypted text : "+plain_text);
	}
}