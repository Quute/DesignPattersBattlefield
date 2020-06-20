package FactoryBattlefield;

interface Shape{
    void draw();
}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
abstract class AbstractShapeFactory{
    protected abstract Shape factoryMethod();
    public Shape getShape(){
        return factoryMethod();
    }
}
class RectangleFactory extends AbstractShapeFactory{
    protected Shape factoryMethod(){
        return new Rectangle();
    }
}
class SquareFactory extends AbstractShapeFactory{
    protected Shape factoryMethod(){
        return new Square();
    }
}
class CircleFactory extends AbstractShapeFactory{
    protected Shape factoryMethod(){
        return new Circle();
    }
}


public class AbstractCreator {
    public static void main(String[] args) {
        Shape shape1 = new CircleFactory().getShape();
        shape1.draw();
        Shape shape2 = new SquareFactory().getShape();
        shape2.draw();
        Shape shape3 = new RectangleFactory().getShape();
        shape3.draw();

    }
}
