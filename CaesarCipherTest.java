import java.io.*;
public class CaesarCipherTest
{
  public static void main(String[] args)throws Exception
  {
  File file = new File("data.txt");
  BufferedReader br = new BufferedReader(new FileReader(file));
  String st="";
  String temp;
  char ch;
	while ((temp = br.readLine()) != null)
    	st=st+temp;
  	int key=1;
	int len=st.length();
	String cipher="";
	int i=0;
	while(i!=len)
	{
		int t=st.charAt(i)+key;
				char ch1=(char)t;
				cipher=cipher+ch1;
				i++;
			
	}
	BufferedWriter bufferedWriter = null;
        try {
            File myFile = new File("Secret.txt");
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(cipher);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){
            }
		}

  }
}