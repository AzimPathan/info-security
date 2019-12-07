import java.util.*;

class EuclidGCD
{
    long number1;
    long number2;
    long gcd;
    
    EuclidGCD(int number1, int number2)
    {
        this.number1 = number1;
        this.number2 = number2;
    }
    EuclidGCD()
    {
    }
    
    long calculateGCD(Long number1, Long number2)
    {
        if(number2==0)
        {
            return number1;
        }
        return calculateGCD(number2, number1%number2);
    }
    
    public static void main(String[] args)
    {
        EuclidGCD obj = new EuclidGCD();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Two Numbers: ");
        obj.number1 = sc.nextLong();
        obj.number2 = sc.nextLong();
        
        obj.gcd = obj.calculateGCD(obj.number1, obj.number2);
        
        System.out.println("GCD: " + obj.gcd);
    }
}