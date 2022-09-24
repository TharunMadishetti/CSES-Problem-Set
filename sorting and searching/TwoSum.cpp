#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n,sum;
    cin>>n>>sum;
    vector<int> a(n),b(n);
    map<int,pair<int,int>> m;
    int i=0;
    while(i<n)
    {
        cin>>a[i];
        m[a[i]].first=i+1;
        if(m[a[i]].second==0)
        m[a[i]].second=i+1;
        i++;
    }
    sort(a.begin(),a.end());
    int j=n-1;
    i=0;
    while(i<j)
    {
        if(a[i]+a[j]==sum)
        break;
        if(a[i]+a[j]>sum)
        j--;
        else
        i++;
    }
    if(a[i]+a[j]==sum && i!=j)
    {
        if(a[i]==a[j])
        cout<<m[a[i]].first<<" "<<m[a[i]].second;
        else
        cout<<m[a[i]].first<<" "<<m[a[j]].first;
    }
    else 
    cout<<"IMPOSSIBLE"<<endl;
    return 0;
}