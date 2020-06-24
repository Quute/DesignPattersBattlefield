package TEMPLATE_Morte;
/*
Bir işlemdeki algoritmanın iskeletini tanımlayıp bazı adımları subclasslara
ertelemeye yarar.Belirli bir algoritmanın yapısını değiştirmeden subclassları
tekrar belirler.
MOTIVATION:
SPECIFY THE ORDER OF OPERATIONS.
yöntemlerin işlem sıralarını belirlemek için kullanır fakat subclasslar
kendi kendi implementationlarını yapabilirler.

Ne zaman kullanırız???
Bir algoritmanın değişmeyen parçalarını subclasslara uygulamak için.
subclass larda kod çoğalmasını önlemek için.
alt sınıfların üst sınıf işlemlerini nasıl genişlettiklerini kontrol etmek için.

*** bir subclass ın yapması gereken işlem sayısını en aza indirmeye çalışın.
*** template methodda parent class subclass daki operasyonu çağırır tersi olmaz.
 */
abstract class HouseTemplate{
    // template method, final so subclasses cannot override it.
    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built");
    }
    // default implementation, hook method
    private void buildWindows(){
        System.out.println("Building Glass Windows");
    }
    public abstract void buildPillars();
    public abstract void buildWalls();
    private void buildFoundation(){
        System.out.println("Building foundation with cement,iron rods and sand");
    }
}
class WoodenHouse extends HouseTemplate{

    @Override
    public void buildPillars() {
        System.out.println("Building Wooden Pillars ");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }
}
class GlassHouse extends HouseTemplate{

    @Override
    public void buildPillars() {
        System.out.println("Building Iron Pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building glass walls");
    }
}
public class Template {
    public static void main(String[] args) {
        HouseTemplate houseType = new WoodenHouse();
        //using template method
        houseType.buildHouse();
        System.out.println("************");
        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
