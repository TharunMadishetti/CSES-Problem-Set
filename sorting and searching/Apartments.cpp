#include <bits/stdc++.h>

using namespace std;

void solve()
{
    int n,k,m;
    cin>>n>>m>>k;
    int req[n],av[m];
    for(int i=0;i<n;i++)
    cin>>req[i];
    for(int i=0;i<m;i++)
    cin>>av[i];
    sort(av,av+m);
    sort(req,req+m);
    int i=0,j=0,c=0;
    while(i<n && j<m)
    {
        if(req[i]==av[j] ||(req[i]-k<=av[j] && req[i]+k>=av[j]))
        {
            i++;
            j++;
            ++c;
        }
        else
        {
            if(req[i]-av[j]>k)
            j++;
            else
            i++;
        }
    }
    cout<<c<<endl;
}
int main()
{
    solve();
    return 0;
}