#include <iostream>
using namespace std;
int main() {
    int n;
    cin>>n;
    if(n%2!=0){
     int i;
     for(i=1;i<=(n+1)/2;i++){
        int space;
        for(space=1;space<=2*((n+1)/2)-2*i;space++){
            cout<<" ";
        }
        int j;
        for(j=i;j>=1;j--){
              if(i==1){
         cout<<" "<<j;}
         else cout<<j<<" ";
        }
        int space2;
        for(space2=1;space2<=2*i-3;space2++){
            cout<<" ";
        }
        int k;
        for(k=1;k<=i;k++){
          if(i==1){
            break;}  
        cout<<k<<" ";
        }
        cout<<endl;
    }
    
     for(i=((n+1)/2)-1;i>=1;i--){
        int space;
        for(space=1;space<=2*((n+1)/2)-2*i;space++){
            cout<<" ";
        }
        int j;
        for(j=i;j>=1;j--){
               cout<<j<<" ";
        }
        int space2;
        for(space2=2*i-3;space2>=1;space2--){
            cout<<" ";
        }
        int k;
        for(k=1;k<=i;k++){
          if(i==1){
            break;}  
        cout<<k<<" ";
        }
        cout<<endl;
    }
  }
}
