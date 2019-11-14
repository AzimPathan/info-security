import java.util.*;

class OneTimePadCipher
{
	String key;
	void GenKey(int l)
	{
		Random r = new Random();
     	String k = "";
     	char q  = 'A';
      	for(int i=0;i<l;i++)
         	k = k + (char) (r.nextInt(26) + q);
      	this.key = k;
    }
	String encryptOne(String s)
	{
		String a="";
     	char q  = 'A';
     	char w  = 'a';

		for(int i=0;i<s.length();i++)
		{
			char ct = s.charAt(i);
			char ck = (key.charAt(i));
			char zz = 'A';
			char qq = 'a';
			int x=0;
			if(Character.isUpperCase(ct))
			{				
				x = (((ct-zz)+(ck-zz))%26)+qq;
			}
			else
			{				
				x = (((ct-qq)+(ck-zz))%26)+qq;
			}

			a += (char)(x);
		}
		return a;
	}

	String decryptOne(String s)
	{
		String a="";
     	char q  = 'A';
     	char w  = 'a';

		for(int i=0;i<s.length();i++)
		{
			char ct = s.charAt(i);
			char ck = (key.charAt(i));
			char zz = 'A';
			char qq = 'a';
			int x=0;
			if(Character.isUpperCase(ct))
			{
				x = (((ct-zz)-(ck-zz))%26);
				if(x<0)
				{
					x+=26;
				}
				x+=zz;

			}
			else
			{				
				x = (((ct-qq)-(ck-zz))%26);
				if(x<0)
				{
					x+=26;
				}
				x+=qq;
			}
			a += (char)(x);
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.print("Enter Plain Text : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

        OneTimePadCipher otc = new OneTimePadCipher();
        otc.GenKey(s.length());
        //System.out.println("Key : " + otc.key);

		String se = otc.encryptOne(s);
		System.out.println("Encrypted Text : "+ se);

		String sd = otc.decryptOne(se);
		System.out.println("Decrypted Text : "+ sd);
	}
}