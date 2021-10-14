#include<iostream>
using namespace std;
int main() {
  int n;
  cin>>n;
  int a[n]={0};
  int i;
  //array input
  for(i=0;i<n;i++){
    cin>>a[i];
  }
  //left array
  int left[n]={0};
  int k;
  left[0]=a[0];
  for(k=1;k<n;k++){
   left[k]=max(left[k-1],a[k]);
  }
  //right array
   int right[n]={0};
   int l;
   right[n-1]=a[n-1];
  for(l=n-2;l>=0;l--){
   right[l]=max(right[l+1],a[l]);
  }
  //water calculation
  int water=0;
  for(int j=0;j<n;j++){
     water=water + min(left[j],right[j])-a[j];
    
  }
  cout<<water;
  
	return 0;
}
