package SingletonWARZONE;
// ADVANTAGES: controlled access to sole instance, reduce name space,permits a variable number of instances.
//IMP Overview: To ensure that this is the only way to instantiate an object, should define a constructor of this class protected or private.

// ONE INSTANCE AND ONLY ONE INSTANCE...
class Singleton{
    private static Singleton uniqueInstance = null;
    private int data = 0;

    private Singleton(){ }
    public static Singleton getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Singleton();

        return uniqueInstance;


    }
    void setData(int myData){
            data = myData;
    }
    int getData(){
        return data;
    }
}

public class Singleton_LAZY {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();

        //set data value
        s.setData(55);

        System.out.println("First reference: " +s);
        System.out.println("Singleton data value is : " +s.getData());

    }
}
