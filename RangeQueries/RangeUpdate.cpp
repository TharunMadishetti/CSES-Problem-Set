#include <bits/stdc++.h>
using namespace std;
long sg[4*(int)(2*1e5)];
long lazy[4*(int)(2*1e5)];

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
    sg[i]=sg[2*i+1]+sg[2*i+2];
}
long query(int l,int r,int i,int j,int idx)
{
    if(lazy[idx]!=0)
    {
        sg[idx]+=(r-l+1)*lazy[idx];
        lazy[2*idx+1]+=lazy[idx];
        lazy[2*idx+2]+=lazy[idx];
        lazy[idx]=0;
    }
    if(r<i || j<l)
    return 0;
    if(i<=l && j>=r)
    return sg[idx];
    int mid=(l+r)/2;
    return query(l,mid,i,j,2*idx+1)+query(mid+1,r,i,j,2*idx+2);   
}
void update(int l,int r,int idx,int low,int high,int val)
{
   if(lazy[idx]!=0)
    {
        sg[idx]+=(r-l+1)*lazy[idx];
        lazy[2*idx+1]+=lazy[idx];
        lazy[2*idx+2]+=lazy[idx];
        lazy[idx]=0;
    }
    if(low>r || high<l)
    return;
    if(low<=l && high>=r)
    {
        lazy[idx]+=val;
        return;
    }
    int mid=(l+r)/2;
    update(l,mid,2*idx+1,low,high,val);
    update(mid+1,r,2*idx+2,low,high,val); 
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
        int t;
        cin>>t;
        if(t==1)
        {
            int a,b,u;
            cin>>a>>b>>u;
            update(0,n-1,0,a,b,u);
        }
        else 
        {
            int k;
            cin>>k;
            k--;
            cout<<query(0,n-1,k,k,0)<<endl;
        }
        
    }
    return 0;
}