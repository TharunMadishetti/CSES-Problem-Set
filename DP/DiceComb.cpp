#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    vector<long long> dp(n+1,0);
    int mod=1e9+7;
    dp[0]=dp[1]=1;
    int i=2;
    for(i;i<=n;i++)
    {
        for(int j=1;j<=6;j++)
        {
            if(j>i)continue;
            dp[i]=(dp[i]%mod+dp[i-j]%mod)%mod;
        }
    }
    cout<<dp[n]%mod<<endl;
    return 0;
}