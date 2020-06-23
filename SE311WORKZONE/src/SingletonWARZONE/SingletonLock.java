package SingletonWARZONE;

class Singleton2{
    private volatile static Singleton2 uniqueInstance = null;
    private int data = 0;

    private Singleton2(){ }
    public static Singleton2 getInstance(){
        if(uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }

            }
        }
        return uniqueInstance;
    }

    void setData(int myData){
        data = myData;
    }
    int getData(){
        return data;
    }
}
public class SingletonLock {
    public static void main(String[] args) {

            Singleton s = Singleton.getInstance();

            //set data value
            s.setData(55);

            System.out.println("First reference: " +s);
            System.out.println("Singleton data value is : " +s.getData());
    }
}
