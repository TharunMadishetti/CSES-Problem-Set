#include <bits/stdc++.h>

using namespace std;

void solve()
{
    int n,p;
    cin>>n>>p;
    int a[n];
    for(int i=0;i<n;i++)
    cin>>a[i];
    sort(a,a+n);
    int i=0,j=n-1,c=0;
    while(i<=j)
    {
        if(a[i]+a[j]<=p)
        {
            i++;
            j--;
            
        }
        else
        {
           j--;
        }
        ++c;
    }
    cout<<c<<endl;
}
int main()
{
    solve();
    return 0;
}