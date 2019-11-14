#include<bits/stdc++.h>
using namespace std;

int getCRT(vector<int> v, vector<int> r)
{
    int i,res=1,n=v.size();
    while(1)
    {
        for(i=0;i<n;i++)
        {
            if(res%v[i]!=r[i])
                break;
        }
        if(i==n)
            return res;
        res++;
    }
}

int main()
{
    vector<int> v,r;
    int n,ele;
    cout << "Enter no. of elements : ";
    cin >> n;
    cout << "Enter " << n << " elements for 1st vector: ";
    for(int i=0;i<n;i++)
    {
        cin >> ele;
        v.push_back(ele);
    }
    cout << "Enter " << n << " elements for 2nd vector: ";
    for(int i=0;i<n;i++)
    {
        cin >> ele;
        r.push_back(ele);
    }
    cout << "CRT Output = " << getCRT(v,r);
    return 0;
}