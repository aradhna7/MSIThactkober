class ObjectPass{ 
    int a; 
  
    ObjectPass(int i){ 
        a = i;
    } 

    ObjectPass inc10(){ 
        ObjectPass obj= new ObjectPass(a+10);
        return obj; 
    } 
} 
public class Objectreturn{ 
    public static void main(String args[]) 
    { 
        ObjectPass ob1 = new ObjectPass(100); 
        ObjectPass ob2 = ob1.inc10(); 
         
  
        System.out.println("ob1.a " + ob1.a); 
        System.out.println("ob2.a " + ob2.a); 
    } 
}