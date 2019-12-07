#include<bits/stdc++.h>
using namespace std;

// Find GCD
int gcd(int fn, int sn)
{
    // Find max among two numbers
    int n=max(fn,sn);
    for(int i=n;i>1;i--)
    {
        // Check if a number divides both fn & sn
        if(fn%i==0 && sn%i==0)
        {
            return i;
        }
    }
    return 1;
}

// Find extended GCD
int gcdExtended(int fn,int sn,int *a,int *b)
{
    // If first number is 0, return second number
    if(fn==0)
    {
        *a=0;
        *b=1;
        return sn;
    }
    // get GCD by passing values to function call
    int i,j;
    int gcd=gcdExtended(sn%fn,fn,&i,&j);
    *a=j-(sn/fn)*i;
    *b=i;
    return gcd;
}

int main()
{
    /* Euclidean distance
    int fn,sn,i,j;
    cin >> fn >> sn;
    cout << gcd(fn,sn);
    cout << gcdExtended(fn,sn,&i,&j);
    */


}