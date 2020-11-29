package shapes;

import shapes.shapes.Circle;
import shapes.shapes.Cuboid;
import shapes.shapes.Cylinder;
import shapes.shapes.Rectangle;
import shapes.template.Shape;

import java.util.Scanner;

public class Main {
    public static final String choiceMessage = """
                 Select your shape.
                 1. Rectangle
                 2. Circle
                 3. Cuboid
                 4. Cylinder
                 Choice:"""+" ";
    public static final String choiceRetry = """
            Please choose a number from 1-4.
            Choice:"""+" ";
    public static final String continueMessage = "Do you want to enter another shape? (Y/N)\nChoice: ";
    public static final String continueRetry = "Please type Y for yes or N for no. Do you want to enter another shape?\nChoice: ";

    public static int inputShapeValue(String shapeName, String valueType, Scanner inputSource) {
        String message1 = "Please input the ";
        String message2 = "Please input a whole number for the ";
        String messageEnd = shapeName + "'s " + valueType + ".\n" + valueType.substring(0, 1).toUpperCase() + valueType.substring(1) + ": ";
        message1 += messageEnd;
        message2 += messageEnd;
        return InputHelper.inputInteger(message1, message2, inputSource);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var inputSource = new Scanner(System.in);
        var shouldContinue = false;
        Shape largestArea = null;
        do {
            Shape shape;
            String information;
            switch (InputHelper.inputBoundedInteger(choiceMessage, choiceRetry, inputSource, 1, 4)) {
                case 1 -> {
                    int length = inputShapeValue("rectangle", "length", inputSource);
                    int width = inputShapeValue("rectangle", "width", inputSource);
                    shape = new Rectangle(length, width);
                    Rectangle rect = (Rectangle) shape;
                    information = "Your rectangle is "+rect.Length()+" long and "+rect.Width()+" wide, with an area of "+rect.Area()+" and "+rect.Sides()+" sides.";
                }
                case 2 -> {
                    int radius = inputShapeValue("circle", "radius", inputSource);
                    shape = new Circle(radius);
                    Circle circle = (Circle) shape;
                    information = "Your circle has a radius of "+circle.Radius()+", a circumference of "+circle.Circumference()+", and an area of "+circle.Area()+".";
                }
                case 3 -> {
                    int length = inputShapeValue("cuboid", "length", inputSource);
                    int width = inputShapeValue("cuboid", "width", inputSource);
                    int height = inputShapeValue("cuboid", "height", inputSource);
                    shape = new Cuboid(length, width, height);
                    Cuboid cube = (Cuboid) shape;
                    information = "Your cuboid is "+cube.Length()+" long, "+cube.Width()+" wide, and "+cube.Height()+" high, with a surface area of "+cube.Area()+", a volume of "+cube.Volume()+" and "+cube.Sides()+" sides.";
                }
                case 4 -> {
                    int radius = inputShapeValue("cylinder", "radius", inputSource);
                    int height = inputShapeValue("cylinder", "height", inputSource);
                    shape = new Cylinder(radius, height);
                    Cylinder cylinder = (Cylinder) shape;
                    information = "Your cylinder has a radius of "+cylinder.Radius()+", a circumference of "+cylinder.Circumference()+", a surface area of "+cylinder.Area()+" and a volume of "+cylinder.Volume()+".";
                }
                default -> throw new IllegalStateException("Shape choice out of bounds. This should not be happening!");
            }
            System.out.println("\n"+information+"\n");
            largestArea = (largestArea == null) ? shape : ((shape.Area() >= largestArea.Area()) ? shape : largestArea);
            shouldContinue = InputHelper.inputBoolean(continueMessage, continueRetry, inputSource);
        }
        while(shouldContinue);
        System.out.println("Out of all the shapes you've entered, the one with the largest area is a "+largestArea.Name()+", with an area of "+largestArea.Area()+".");
    }
}