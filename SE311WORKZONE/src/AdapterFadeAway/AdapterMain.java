package AdapterFadeAway;
/*
Bir interface i beklenen interface e dönüştürmeye yarar.
Adapter,sınıfların uyumsuzluklarını ortadan kaldırarak birlikte çalışmalarını sağlar

Motivation:
    Bazen bir kütüphane ya da toolkit uyumsuzluk yüzünden çalışamaz ve kullanılamaz
    Kaynak kod olduğu için kütüphane arayüzünü değiştirmeyiz bu yüzden adapter kullanırız.

TWO TYPES OF ADAPTERS:
Class Adapter:inheritance kullanır ve sadece bir sınıfı wraplayabilir.
   Bir interface'i kaplayamaz tanım gereği bazı temel sınıflar türetilmelidir.
Object ADAPTER:Composition kullanır ve class ve ya interface olan her şeyi sarabilir.
   private,encapsulated member, sardığı interface nesnesi örneğini içerdiğinden bunu yapabilir.
 */
//OBJECTS ADAPTER
interface NASocket{
    int usingNASocket();

}
class EURSocket{
    public int usingEURSocket(){
        System.out.println("Giving you 220 volt using EU Connection");
        return 220;
    }

}
class ConnectorAdapterNAtoEUR extends EURSocket implements NASocket{

    @Override
    public int usingNASocket() {
        int voltage = usingEURSocket();
        return voltage;
    }
}
class VCR{
    public void powerUp(int voltage){
        System.out.println("powered up");
    }
}


public class AdapterMain {
    public static void main(String[] args) {
        NASocket socket = new ConnectorAdapterNAtoEUR();
        int voltage = socket.usingNASocket();
        VCR vcr = new VCR();
        vcr.powerUp(voltage);

    }
}
