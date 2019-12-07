import java.util.Scanner;
import java.math.BigInteger;        // For output conversion
import java.security.MessageDigest; // For cryptographic hash functions
import java.security.NoSuchAlgorithmException;  // Handle exception

class Hash_Test
{
    public static String hash(String msg, int opt)
    {
        try
        {
            MessageDigest md;
            // Get the hash instance
            switch(opt)
            {
                case 1:
                        md=MessageDigest.getInstance("MD2");
                        break;
                case 2:
                        md=MessageDigest.getInstance("MD5");
                        break;
                case 3:
                        md=MessageDigest.getInstance("SHA-1");
                        break;
                case 4:
                        md=MessageDigest.getInstance("SHA-256");
                        break;
                case 5:
                        md=MessageDigest.getInstance("SHA-512");
                        break;
                default:
                        md=MessageDigest.getInstance("MD2");    // default
                        break;
            }

            // Calculate hash value
            byte[] hashValue=md.digest(msg.getBytes());

            // Convert byte to number
            BigInteger num=new BigInteger(1,hashValue);

            // Convert to hex value
            String messageDigest=num.toString(16);
            while(messageDigest.length()<32)
            {
                messageDigest="0"+messageDigest;
            }
            return messageDigest;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws NoSuchAlgorithmException
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter message : ");
        String msg=sc.nextLine();
        System.out.print("Choose algorithm\n1. MD2\n2. MD5\n3. SHA-128\n4. SHA-256\n5. SHA-512\nOption : ");
        int opt=sc.nextInt();
        if(opt<1 && opt>5)
            System.out.println("Invalid option!");
        else
            System.out.println(hash(msg,opt));
    }
}