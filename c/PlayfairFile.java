import java.awt.*;
import java.util.*;
import java.io.*;
public class PlayfairFile{
  
  private int length = 0;
  private String [][] table;
  public static void main(String[] args){
    PlayfairFile pf = new PlayfairFile();
  }
  private PlayfairFile(){
    System.out.println("Enter Key:");
    Scanner sc = new Scanner(System.in);
    String keyword = sc.next();       
    while(keyword.equals(""))
      keyword = parseString(sc);
    System.out.println();
    table = this.cipherTable(keyword);
	String st="";
	 File file = new File("plainfile.txt");
	 try{
 
  BufferedReader br = new BufferedReader(new FileReader(file));
	String temp;
  char ch;
  
  while ((temp = br.readLine()) != null)
    st=st+temp;
  }
  catch(Exception e)
  {
  }
    //ch=st.charAt(0);
	//int key=1;
	String input=st;
    
    
    String output = cipher(input);
    String decodedOutput = decode(output);
    
 
    this.printTable(table);
    this.printResults(output,decodedOutput);
  }
  
  
  private String parseString(Scanner s){
    String parse = s.nextLine();
    parse = parse.toUpperCase();
    parse = parse.replaceAll("[^A-Z]", "");
    parse = parse.replace("J", "I");
    return parse;
  }
  
  
  private String[][] cipherTable(String key){
    String[][] playfairTable = new String[5][5];
    String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    
    
    for(int i = 0; i < 5; i++)
      for(int j = 0; j < 5; j++)
        playfairTable[i][j] = "";
    
    for(int k = 0; k < keyString.length(); k++){
      boolean repeat = false;
      boolean used = false;
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
          if(playfairTable[i][j].equals("" + keyString.charAt(k))){
            repeat = true;
          }else if(playfairTable[i][j].equals("") && !repeat && !used){
            playfairTable[i][j] = "" + keyString.charAt(k);
            used = true;
          }
        }
      }
    }
    return playfairTable;
  }
 
  private String cipher(String in){
    length = (int) in.length() / 2 + in.length() % 2;
    
    
    for(int i = 0; i < (length - 1); i++){
      if(in.charAt(2 * i) == in.charAt(2 * i + 1)){
        in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
        length = (int) in.length() / 2 + in.length() % 2;
      }
    }
    
   
    String[] digraph = new String[length];
    for(int j = 0; j < length ; j++){
      if(j == (length - 1) && in.length() / 2 == (length - 1))
        in = in + "X";
      digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);
    }
    
    
    String out = "";
    String[] encDigraphs = new String[length];
    encDigraphs = encodeDigraph(digraph);
    for(int k = 0; k < length; k++)
      out = out + encDigraphs[k];
    return out;
  }
  
 
  private String[] encodeDigraph(String di[]){
 
    String[] enc = new String[length];
    for(int i = 0; i < length; i++){
      char a = di[i].charAt(0);
      char b = di[i].charAt(1);
      int r1 = (int) getPoint(a).getX();
      int r2 = (int) getPoint(b).getX();
      int c1 = (int) getPoint(a).getY();
      int c2 = (int) getPoint(b).getY();
      
      
      if(r1 == r2){
        c1 = (c1 + 1) % 5;
        c2 = (c2 + 1) % 5;
        
      
      }else if(c1 == c2){
        r1 = (r1 + 1) % 5;
        r2 = (r2 + 1) % 5;
      
 
      }else{
        int temp = c1;
        c1 = c2;
        c2 = temp;
      }
      
      
      enc[i] = table[r1][c1] + "" + table[r2][c2];
    }
    return enc;
  }
  
  
  private String decode(String out){
    String decoded = "";
    for(int i = 0; i < out.length() / 2; i++){
      char a = out.charAt(2*i);
      char b = out.charAt(2*i+1);
      int r1 = (int) getPoint(a).getX();
      int r2 = (int) getPoint(b).getX();
      int c1 = (int) getPoint(a).getY();
      int c2 = (int) getPoint(b).getY();
      if(r1 == r2){
        c1 = (c1 + 4) % 5;
        c2 = (c2 + 4) % 5;
      }else if(c1 == c2){
        r1 = (r1 + 4) % 5;
        r2 = (r2 + 4) % 5;
      }else{
        int temp = c1;
        c1 = c2;
        c2 = temp;
      }
      decoded = decoded + table[r1][c1] + table[r2][c2];
    }
    return decoded;
  }
  
  
  private Point getPoint(char c){
    Point pt = new Point(0,0);
    for(int i = 0; i < 5; i++)
      for(int j = 0; j < 5; j++)
        if(c == table[i][j].charAt(0))
          pt = new Point(i,j);
    return pt;
  }
  
  private void printTable(String[][] printedTable){
    System.out.println("This is the cipher table from the given keyword.");
    System.out.println();
    
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        System.out.print(printedTable[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();
  }
  

    private void printResults(String enc, String dec){
	BufferedWriter bufferedWriter = null;
        try {
            File myFile = new File("cipherfile.txt");
            if (!myFile.exists()) 
			{
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(enc);
        } 
		catch (IOException e)
		{
            e.printStackTrace();
        } 
		finally
		{
            try
			{
                if(bufferedWriter != null) bufferedWriter.close();
            } 
			catch(Exception ex)
			{
                 
            }
		}
    }
}
