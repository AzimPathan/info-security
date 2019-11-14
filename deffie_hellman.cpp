#include<bits/stdc++.h>
using namespace std;

long long int power(long long int base,long long int exp,long long int q)
{
    if(exp==1)  // If power is 1, return the base
        return base;
    else
        return (( long long int)pow(base,exp)%q);
}

long long int getPublicKey(long long int p,long long int g,long long int n)
{
    return power(g,n,p);
}

long long int getSecretKey(long long int p,long long int priK,long long int pubK)
{
    return power(pubK,priK,p);
}

int main()
{
    /*
        P -> Prime number
        G -> Generator (primitive root of P)
        a -> Alice's private key
        b -> Bob's private key
        x -> Alice's public key
        y -> Bob's public key
        ka -> Alice's symmetric key
        kb -> Bob's symmetric key
    */

    long long int p,g,a,b,x,y,ka,kb;
    cout << "Enter values of P (Prime number) and G (Primitive root) : ";
    cin >> p >> g;

    cout << "Enter private key of Alice : ";
    cin >> a;

    cout << "Enter private key of Bob : ";
    cin >> b;

    // Compute public keys of Alice and Bob
    x=getPublicKey(p,g,a);
    y=getPublicKey(p,g,b);
    cout << "\nPublic key of Alice : " << x << endl;
    cout << "Public key of Bob : " << y << endl;

    // Generate secret keys for Alice and Bob
    cout << "Secret key for Alice : " << getSecretKey(p,a,y) << endl;
    cout << "Secret key for Bob : " << getSecretKey(p,b,x) << endl;

    return 0;
}