#include<iostream>
using namespace std;

//bottomup approach
int bottomup(int* wt,int* profit,int n,int capacity)
{
    int dp[100][100]={0};
    for(int i=0;i<=n;i++)
    {
        for(int j=0;j<=capacity;j++)
        {
            if(i==0 || j==0)
            {
                dp[i][j]=0;
            }

                int inc=0,exc=0;
                if(wt[i-1]<=j)
                {
                    inc=profit[i-1]+dp[i-1][j-wt[i-1]];
                }
                exc=dp[i-1][j];
                dp[i][j]=max(inc,exc);

        }
    }
    return dp[n][capacity];
}

int knapsack(int *wt,int* profit,int n,int capacity)
{
    if(n==0 || capacity==0)
    {
        return 0;
    }
    int op1=0;
    if(wt[n-1]<=capacity)
    {
        op1=profit[n-1]+knapsack(wt,profit,n-1,capacity-wt[n-1]);
    }
    int op2=knapsack(wt,profit,n-1,capacity);
    int ans=max(op1,op2);
    return ans;
}


int main()
{
    int wt[]={2,2,3,1};
    int a;
    int profit[]={10,20,10,15};
    int n=sizeof(wt)/sizeof(int);
    int capacity;
    cin>>capacity;
    
    cout<<bottomup(wt,profit,n,capacity)<<endl;
    cout<<knapsack(wt,profit,n,capacity)<<endl;
}
