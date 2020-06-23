package FactoryBattlefield;
interface Shape1{
    void draw();
}
class Rectangle1 implements Shape1{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");

    }
}
class Square1 implements Shape1{

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
class Circle1 implements Shape1{

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
class ShapeFactory{
    // use getShape method to get object of type shape
    public Shape1 getShape(String shapeType){
        if(shapeType == null){
            return null;

        }else if(shapeType.equalsIgnoreCase("CIRCLE"))
            return new Circle1();

        else if(shapeType.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle1();

        else if(shapeType.equalsIgnoreCase("SQUARE"))
            return new Square1();

        return null;

    }}
public class ConcreteCreator {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape1 shape1 = new ShapeFactory().getShape("CIRCLE");
        shape1.draw();

        Shape1 shape2 = new ShapeFactory().getShape("RECTANGLE");
        shape2.draw();

    }
}
