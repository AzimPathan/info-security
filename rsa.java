import java.util.Scanner;

class rsa {
    static int gcd(int a,int b){
        if (b == 0) 
            return a; 
        return gcd(b, a % b);  
    }

    static int powmod(int a,int b,int n){
       
        if(b==1){
            return a%n;
        }
        else if(b%2==0){
            return (powmod(a,b/2,n)*powmod(a,b/2,n))%n;
        }
        else {
            return (powmod(a,b-1,n)*powmod(a,1,n))%n;
        }
    }

    static int modInverse(int a, int m){ 
        int m0 = m; 
        int y = 0, x = 1; 
  
        if (m == 1) 
            return 0; 
  
        while (a > 1){ 

            int q = a / m; 
            int t = m; 
            m = a % m; 
            a = t; 
            t = y; 
            y = x - q * y; 
            x = t; 
        }
        if (x < 0) 
            x += m0; 
  
        return x; 
    } 
    static int finde(int n){
        
        for(int i=2;i<n;i++){
            if(gcd(n,i)==1){
                return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int n = p*q;
        int phi =(p-1)*(q-1);

        int e = finde(phi);

        int k = 2;  
        int d = modInverse(e,phi);
        System.out.println(d);

        System.out.println("enter message");
        int m = sc.nextInt();
        int c=powmod(m,e,n);
        System.out.println("Cipher text "+c);
        int dec = powmod(c, d, n);
        System.out.println("Orignal text "+dec);


    }
}