package AdapterFadeAway;

interface NASocket1{
    int usingNASocket();

}
class EURSocket1{
    public int usingEURSocket(){
        System.out.println("Giving you 220 volt using EU connection");
        return 220;
    }
}
class ConnectorAdapterNAtoEUR1 extends EURSocket1 implements NASocket1{

    @Override
    public int usingNASocket() {
        int voltage = usingEURSocket();
        return voltage;
    }
}
class VCR1{
    public void powerUp(int voltage){
        System.out.println("Powered up");
    }
}
public class ClassAdapter {
    public static void main(String[] args) {
        //Create adapter
        NASocket1 socket = new ConnectorAdapterNAtoEUR1();
        int voltage = socket.usingNASocket();
        VCR1 vcr = new VCR1();
        vcr.powerUp(voltage);
    }
}
