/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

import Prototype.shapes.Circle;
import Prototype.shapes.Rectangle;
import Prototype.shapes.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrnov
 */

/*
Prototype es un patrón de diseño creacional 
que permite la clonación de objetos, incluso los complejos, sin acoplarse a sus clases específicas.

Todas las clases prototipo deben tener una interfaz común que haga posible 
copiar objetos incluso si sus clases concretas son desconocidas. 
Los objetos prototipo pueden producir copias completas, 
ya que los objetos de la misma clase pueden acceder a los campos privados de los demás.

*/

/*
Uso del patrón en Java

Ejemplos de uso: El patrón Prototype está disponible en Java listo para usarse con una interfaz Cloneable.

Cualquier clase puede implementar esta interfaz para hacerse clonable.

    java.lang.Object#clone() (la clase debe implementar la interfaz java.lang.Cloneable)

Identificación: El prototipo puede reconocerse fácilmente por un método clone o copy, etc.
*/
public class Demo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(i + ": original - "+ shapes.get(i) +" copy - "+shapesCopy.get(i));
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
