import java.util.*;
class CRTDe
{
	public static void main(String args[])
	{
		System.out.println("");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array ele:");
		int arr1[]=new int[3];
		int arr2[]=new int[3];
		int M=1,m1,m2,m3;
		int x,y1,y2,y3;
		for(int i=0;i<3;i++)
		{
			arr1[i]=sc.nextInt();
		}
		for(int i=0;i<3;i++)
		{
			arr2[i]=sc.nextInt();
		}
		for(int i=0;i<3;i++)
		{
			M=M*arr2[i];
		}
		
		
			m1=M/arr2[0];
			m2=M/arr2[1];
			m3=M/arr2[2];
			int i=1;
			while(i!=10000)
			{
				if((m1*i)%arr2[0]==1)
				{
					y1=i;
					//System.out.println(y1);
					break;
				}
				else
					i++;
				
			}
			int j=1;
			System.out.println("value of y1:"+i);
			while(j!=10000)
			{
				if((m2*j)%arr2[1]==1)
				{
					y2=j;
					//System.out.println(y2);
					break;
				}
				else
					j++;
				
			}
			System.out.println("Value of y2:"+j);
			
		int k=1;
			//System.out.println(m2);
			while(k!=10000)
			{
				if((m3*k)%arr2[2]==1)
				{
					y3=k;
					//System.out.println(y3);
					break;
				}
				else
					k++;
				
			}
			System.out.println("value of Y3:"+k);
			//sSystem.out.println(y1);
			int a1=arr1[0],a2=arr1[1],a3=arr1[2];
			x=((a1*m1*i)+(a2*m2*j)+(a3*m3*k))%M;
			System.out.println("Value of X:"+x);
		
		
	}
}