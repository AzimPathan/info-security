#include<bits/stdc++.h>
using namespace std;

string encrypt(string msg, int key){
    int n = msg.length(), i, j, k = -1, row = 0, col = 0;
    string res;
    char railMatrix[key][n];

    for(i = 0; i < key; ++i)
        for(j = 0; j < n; ++j)
            railMatrix[i][j] = '\n';

    for(i = 0; i < n; ++i){
        railMatrix[row][col++] = msg[i];

        if(row == 0 || row == key-1)
            k= k * (-1);

        row = row + k;
    }

    for(i = 0; i < key; ++i)
        for(j = 0; j < n; ++j)
            if(railMatrix[i][j] != '\n')
                res+=railMatrix[i][j];
    return res;
}

string decrypt(string msg, int key){
    int n = msg.length(), i, j, k = -1, row = 0, col = 0, m = 0;
    string res;
    char railMatrix[key][n];

    for(i = 0; i < key; ++i)
        for(j = 0; j < n; ++j)
            railMatrix[i][j] = '\n';

    for(i = 0; i < n; ++i){
        railMatrix[row][col++] = '*';

        if(row == 0 || row == key-1)
            k= k * (-1);

        row = row + k;
    }

    for(i = 0; i < key; ++i)
        for(j = 0; j < n; ++j)
            if(railMatrix[i][j] == '*')
                railMatrix[i][j] = msg[m++];

    row = col = 0;
    k = -1;

    for(i = 0; i < n; ++i){
        res+=railMatrix[row][col++];

        if(row == 0 || row == key-1)
            k= k * (-1);

        row = row + k;
    }
    return res;
}

void getData(string &msg, int &key)
{
    cout << "Enter message : ";
    cin.ignore(1,'\n');
    getline(cin,msg);
    cout << "Enter key : ";
    cin >> key;
}

int main(){

    string msg;
    int key,opt;
    do
    {
        cout << "\nChoose option\n1. Encrypt message\n2. Decrypt message\n3. Exit\nOption : ";
        cin >> opt;
        switch(opt)
        {
            case 1:
                    getData(msg,key);
                    msg=encrypt(msg,key);
                    cout << "Encrypted message : " << msg << endl;
                    break;
            case 2:
                    getData(msg,key);
                    msg=decrypt(msg,key);
                    cout << "Decrypted message : " << msg << endl;
                    break;
            case 3:
                    break;
            default:
                    cout << "Invalid option!" << endl;
        }
    }while(opt!=3);
    return 0;
}