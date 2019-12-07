 #include<iostream> 
using namespace std; 
typedef long long int ll; 

ll gcd(ll a, ll b) 
{ 
	if (!a) 
	return b; 
	return gcd(b%a,a); 
} 

ll reduceB(ll a, string b) 
{ 
	ll mod = 0; 

	//calculating mod of b with a to make b like 0 <= b < a 
	for (int i=0; i<b.length(); i++) 
		mod = (mod*10 + b[i] - '0')%a; 

	return mod;
} 

ll gcdLarge(ll a, string b) 
{ 
	ll num = reduceB(a, b); 

	return gcd(a, num); 
} 

int main() 
{ 
    cout<<"\nEnter Smaller Number: ";
	ll a;
    cin>>a;
    
    cout<<"\nEnter Larger Number: ";
    string b;
    cin>>b;

	cout << "\nGCD: "<<gcdLarge(a, b)<<"\n\n"; 

	return 0; 
} 
