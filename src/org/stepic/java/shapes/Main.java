package org.stepic.java.shapes;

public class Main {

    public static void main(String[] args){
        Circle circle = new Circle(
                new Point(0,0), 1, Color.BLACK);

        Triangle triangle = new Triangle(
                new Point(0,0), new Point(1,0), new Point(0,1),Color.RED);

        Square square = new Square(
                new Point(5,5), 2, Color.BLUE);

        Shape shape = triangle;
        Object object = triangle;
        triangle = (Triangle) object;// instanceof, equals

        Shape[] shapes = {circle,triangle,square};
        printArrayElements(shapes);

        Shape maxShape = findShapeWithMaxArea(shapes);
        System.out.println("Shape with max area: " + maxShape);
    }

    private static void printArrayElements(Object[] objects){
        for(int i = 0; i<objects.length;i++){
            System.out.println(i+": " + objects[i]);
        }
    }

    private static Shape findShapeWithMaxArea(Shape[] shapes){
        Shape maxShape = null;
        double maxArea = Double.NEGATIVE_INFINITY;
        for(Shape shape : shapes){
            double area = shape.getArea();
            if (area > maxArea){
                maxArea = area;
                maxShape = shape;
            }
        }
        return maxShape;
    }
}
