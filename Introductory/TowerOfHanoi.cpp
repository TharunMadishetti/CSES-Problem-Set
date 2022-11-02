#include <bits/stdc++.h>
using namespace std;
void solve(int n,int s,int d,int h)
{
    // cout<<n<<" "<<s<<" "<<d<<" "<<h<<endl;
    if(n==1)
    {
        cout<<s<<" "<<d<<endl;
        return;
    }
    solve(n-1,s,h,d);
    cout<<s<<" "<<d<<endl;
    solve(n-1,h,d,s);
    
}
int solve2(int n)
{
    // cout<<n<<" "<<s<<" "<<d<<" "<<h<<endl;
    if(n==1)
    {
        return 1;
    }
    return 2*solve2(n-1)+1;
}
int main()
{
    long n;
    cin>>n;
    cout<<solve2(n)<<endl;
    solve(n,1,3,2);
}
