n=int(input())
l=[int(s) for s in input().split()]
ans=0
for i in range(1,n): 
  if(l[i]<l[i-1]):
    ans+=l[i-1]-l[i];
    l[i]=l[i-1]
print(ans)