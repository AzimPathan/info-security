import java.io.*;
import java.util.*;

class Ceasar
{
    private String plainText;
    private int shiftKey;
    private int cipherLength;
    public StringBuffer decodedText;
    public StringBuffer cipherText;
    
    
    Ceasar()
    {
        this.cipherLength=0;
    }
    
    Ceasar(String plainText, int shiftKey, StringBuffer cipherText)
    {
        this.plainText = plainText;
        this.shiftKey = shiftKey;
        this.cipherLength=0;
        this.cipherText = cipherText;
    }
    
    public void getInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Plain Text:\n");
        this.plainText = sc.nextLine();
        System.out.println("\nEnter Shift Key:\n");
        this.shiftKey = sc.nextInt();
    }
    
    public void output()
    {
        System.out.println(); System.out.println();
        
        System.out.println("Output: ");
        
        System.out.println(); System.out.println();
        
        int length = this.cipherLength;
        int lines = length/50;
        int index=0;
        
        while(index<length)
        {
            for(int j=0; j<10 && index<length; j++)
            {
                for(int k=0; k<5 && index<length; k++)
                {
                    System.out.print(cipherText.charAt(index));
                    index++;
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        
        System.out.println();
        System.out.println();
    }
    
    public void displayContent()
    {
        System.out.println("Plain Text: " + this.plainText);
        System.out.println("Shift Key: " + this.shiftKey);        
        System.out.println("Cipher Text: " + cipherText);
    }
    
    public void encodeString()
    {
        StringBuffer tmpStr = new StringBuffer(this.plainText);
        
        for(int i=0; i<tmpStr.length(); i++)
        {
            Character tmp = tmpStr.charAt(i);
            tmpStr.setCharAt(i, Character.toUpperCase(tmp));
        }
        
        StringBuffer cipherText = new StringBuffer();
        
        for(int i=0; i<tmpStr.length(); i++)
        {
            Character tmp = tmpStr.charAt(i);
            int tmpAscii = (int)(tmp);
            
            if(tmpAscii>=65 && tmpAscii<=91)
            {
                Character.toUpperCase(tmp);
                int ascii = (int)tmp;
                ascii = ascii + this.shiftKey;
                if(ascii>91)
                {
                    ascii = ascii - 91;
                    ascii = ascii + 65;
                }
                
                cipherText.append((char)(ascii));
                cipherLength++;
            }
        }
        
        this.cipherText = cipherText;
    }
    
    public void decodeString()
    {
        StringBuffer tmpStr = new StringBuffer(this.cipherText);
        StringBuffer decodedText = new StringBuffer();
        
        for(int i=0; i<tmpStr.length(); i++)
        {
            Character tmp = tmpStr.charAt(i);
            int tmpAscii = (int)(tmp);
            
            if(tmpAscii>=65 && tmpAscii<=91)
            {
                Character.toUpperCase(tmp);
                int ascii = (int)tmp;
                ascii = ascii - this.shiftKey;
                if(ascii<65)
                {
                    ascii = ascii - 65;
                    ascii = ascii + 91;
                }

                decodedText.append((char)(ascii));
            }
        }
        
        this.decodedText = decodedText;
    }
    
    public static void main(String[] args)
    {
        Ceasar text = new Ceasar();

        text.getInput();
        
        text.encodeString();
        
        //text.displayContent();
        
        text.output();
        
        text.decodeString();
        
        System.out.println("Decrypted Text (Ignored spaces & punctuations):\n\n\n" + text.decodedText + "\n");
        
        System.out.println("\nDecrypted Text (Object stored):\n\n\n" + text.plainText + "\n\n");
        
    }
}