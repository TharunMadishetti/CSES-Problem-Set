#include <bits/stdc++.h>
using namespace std;
long sg[4*(int)(2*1e5)];
void build(int l,int r,int i,int a[])
{
    if(l==r)
    {
        sg[i]=a[l];
        return ;
    }
    int mid=(l+r)/2;
    build(l,mid,2*i+1,a);
    build(mid+1,r,2*i+2,a);
    sg[i]=min(sg[2*i+1],sg[2*i+2]);
}
long query(int l,int r,int i,int j,int idx)
{
    if(r<i || j<l)
    return INT_MAX;
    // cout<<l<<" "<<r<<" "<<sg[idx]<<endl;
    if(i<=l && j>=r)
    return sg[idx];
    int mid=(l+r)/2;
    return min(query(l,mid,i,j,2*idx+1),query(mid+1,r,i,j,2*idx+2));
    
}
int main()
{
    int n,q;
    cin>>n>>q;
    int a[n];
    
    int i=0;
    while(i<n)
    cin>>a[i++];
    build(0,n-1,0,a);
    while(q--)
    {
        int l,r;
        cin>>l>>r;
        l--;
        r--;
        cout<<query(0,n-1,l,r,0)<<endl;
    }
    return 0;
}