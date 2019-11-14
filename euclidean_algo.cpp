#include<bits/stdc++.h>
using namespace std;

int gcdExtended(int fnum,int snum,int *a,int *b)
{
    if(fnum==0)
    {
        *a=0;
        *b=1;
        return snum;
    }
    int i,j;
    int gcd=gcdExtended(snum%fnum,fnum,&i,&j);
    *a=j-(snum/fnum)*i;
    *b=i;
    return gcd;
}


int gcd(int fn, int sn)
{
    int i,n=max(fn,sn);
    for(i=n;i>1;i--)
    {
        if(fn%i==0 && sn%i==0)
        {
            return i;
        }
    }
    return 1;
}

int main()
{
    int firstNum,secondNum,i,j;
    cout << "Enter two numbers : ";
    cin >> firstNum >> secondNum;
    cout << "GCD of " << firstNum << " and " << secondNum << " is " << gcd(firstNum,secondNum) << endl;
    cout << "Euclidean GCD of " << firstNum << " and " << secondNum << " is " << gcdExtended(firstNum,secondNum,&i,&j);
    return 0;
}