#include<iostream>
using namespace std;
int main() {
//no. of testcases
  int t;
  cin>>t;
  for(int i=1;i<=t;i++){
    int n; 
    cin>>n;
    int a[n]={0};
   
    //arrary input
    for(int j=0;j<n;j++){
      cin>>a[j];
    }
    //kadane's algorithm
    int ms=0;
    int cs=0;
    for(int j=0;j<n;j++){
      cs=cs+a[j];
      if(cs<0){
        cs=0;
      }
      ms=max(cs,ms);
    }
    cout<<ms<<endl;
  }
  
	return 0;
}