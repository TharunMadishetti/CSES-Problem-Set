#include <bits/stdc++.h>
#include <iostream>
#include <map>
using namespace std;
int lower_bound(vector<pair<int,int>> arr, int N, int X)
{
    if(N==1)
    {
        if(arr[0].first<=X)
        return 0;
    }
    int mid;
    int low = 0;
    int high = N-1;
 
    while (low <= high) {
        mid = low + (high - low) / 2;
 
       if(arr[mid].first==X)
       return mid;
       else if(arr[mid].first>X)
       high=mid-1;
       else 
       {
           if(arr[mid+1].first<=X)
           low=mid+1;
           else 
           return low;
       }
    }
   
   
    // Return the lower_bound index
    return low;
}
int floorKey(map<int,int> input, int X)
{
    std::vector<pair<int,int>> arr;
    arr.resize(input.size());
    int i=0;
    std::copy(input.begin(), input.end(), arr.begin());
    int ans=lower_bound(arr,input.size(),X);
    // cout<<X<<":"<<arr[ans]<<endl;
    if(ans<input.size() && arr[ans].first<=X)
    return arr[ans].first;
    return -1;
}
int main()
{
    int n,nm;
    cin>>n>>nm;
    map<int,int> m;
    for(int i=0;i<n;i++)
    {
        int x;
        cin>>x;
        m[x]++;
    }
    
    // for ( itr = m.begin(); itr != m.end(); ++itr) {
    //     cout << '\t' << itr->first << '\t' << itr->second
    //          << '\n';
    // }
    for(int i=0;i<nm;i++)
    {
        int k;
        cin>>k;
        int ans=floorKey(m,k);
        
        if(ans==-1)
        {
            cout<<-1<<endl;
        }
        else 
        {
            cout<<ans<<endl;
            m[ans]--;
            if(m[ans]==0)
            m.erase(ans);   
        }
    }
       return 0;
}