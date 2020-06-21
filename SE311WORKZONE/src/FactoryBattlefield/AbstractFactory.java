package FactoryBattlefield;
// CREATING FAMILIES OF RELATED OR DEPENDENT OBJECTS WITHOUT SPECIFYING THEIR CONCRETE CLASSES

// each time interface implements a new product, we have to modify subclasses
/*
we need two dif types of tables
one wood
one steel

wooden carpenter shop
steel another shop

decide what kind of shop and table we need.
 */
 // SELECTING THE RIGHT FACTORY...
interface Shape2{
    void draw();

}
class Rectangle2 implements Shape2{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");

    }
}
class Square2 implements Shape2{

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
class Circle2 implements Shape2{

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
interface Color{
    void fill();
}
class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");

    }
}
class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");

    }
}
class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");

    }
}
abstract class Factory{
abstract Color getColor(String color);
abstract Shape2 getShape(String shape);
}
class ShapeFactory1 extends Factory{

    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape2 getShape(String Type) {
        if(Type == null){
            return null;
        }
        else if(Type.equalsIgnoreCase("CIRCLE"))
            return new Circle2();

        else if(Type.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle2();

        else if(Type.equalsIgnoreCase("SQUARE"))
            return new Square2();

        return null;
    }
}
class ColorFactory extends Factory{

    @Override
    Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED"))
            return new Red();
        else if(color.equalsIgnoreCase("GREEN"))
            return new Green();
        else if(color.equalsIgnoreCase("BLUE"))
            return new Blue();
        return null;

    }

    @Override
    Shape2 getShape(String shape) {
        return null;
    }
}
class FactoryProducer{
    static Factory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory1();
        }else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
public class AbstractFactory {
    public static void main(String[] args) {
        Factory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape2 shapee = shapeFactory.getShape("CIRCLE");
        shapee.draw();

        Shape2 shape11 = shapeFactory.getShape("RECTANGLE");
        shape11.draw();

        Factory colorFactory = FactoryProducer.getFactory("COLOR");

        Color color1 = colorFactory.getColor("BLUE");
        color1.fill();

    }
}
