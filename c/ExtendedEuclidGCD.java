qimport java.util.*;

class ExtendedEuclidGCD
{
    long number1;
    long number2;
    long gcd;
    long x;
    long y;
    
    ExtendedEuclidGCD(int number1, int number2)
    {
        this.number1 = number1;
        this.number2 = number2;
    }
    ExtendedEuclidGCD()
    {
    }
    
    void calculateExtendedGCD(Long number1, Long number2)
    {
        if(number2==0)
        {
            gcd = number1;
            x = 1;
            y = 0;
        }
        
        else
        {
            calculateExtendedGCD(number2, number1%number2);
            Long tmp = x;
            x = y;
            y = tmp - (number1/number2)*y;
        }
    }
    
    public static void main(String[] args)
    {
        ExtendedEuclidGCD obj = new ExtendedEuclidGCD();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Two Numbers: ");
        obj.number1 = sc.nextLong();
        obj.number2 = sc.nextLong();
        
        obj.calculateExtendedGCD(obj.number1, obj.number2);
        
        System.out.println("Equation: " + obj.gcd + " = " + obj.number1 + "*" + obj.x + " + " + obj.number2 + "*" + obj.y);
    }
}