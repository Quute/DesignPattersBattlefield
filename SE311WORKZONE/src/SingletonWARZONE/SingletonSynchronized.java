package SingletonWARZONE;
class Singleton1{

        private static SingletonWARZONE.Singleton1 uniqueInstance;
        private int data = 0;

        private Singleton1(){ }
        //by adding the synchro keyword to getinstance method we force every thread to wait for working one.

        public static synchronized Singleton1 getInstance(){
            if(uniqueInstance == null)

                uniqueInstance = new SingletonWARZONE.Singleton1();

            return uniqueInstance;


        }
        void setData(int myData){
            data = myData;
        }
        int getData(){
            return data;
        }
    }

public class SingletonSynchronized {
    public static void main(String[] args) {
        SingletonWARZONE.Singleton s = SingletonWARZONE.Singleton.getInstance();

        //set data value
        s.setData(55);

        System.out.println("First reference: " +s);
        System.out.println("Singleton data value is : " +s.getData());

    }
}
