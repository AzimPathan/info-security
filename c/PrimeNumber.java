import java.util.*;
import java.io.*;

class PrimeNumber
{ 

	static void factorize(long n) 
	{ 
		int count = 0; 
		while (!(n % 2 > 0)) 
		{ 
			
			n >>= 1; 
			count++; 
		} 
		if (count > 0) 
		{ 
			System.out.println("2"); 
		} 
		for (long i = 3; i <= (long) Math.sqrt(n); i += 2) 
		{ 
			count = 0; 
			while (n % i == 0) 
			{ 
				count++; 
				n = n / i; 
			} 
			if (count > 0) { 
				System.out.println(i); 
			} 
		} 
		if (n > 2) 
		{ 
			System.out.println(n); 
		} 
	} 

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);System.out.println("Prime Factors:"); 
		System.out.println("Enter Number for Prime Factorization:");
		Long num=sc.nextLong();
		System.out.println("Prime Factors:"); 
		long start = System.currentTimeMillis();
		factorize(num);
		long end = System.currentTimeMillis();  
	} 
} 