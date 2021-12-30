/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory.app;

import AbstractFactory.buttons.Button;
import AbstractFactory.checkboxes.Checkbox;
import AbstractFactory.factories.GUIFactory;

/**
 *
 * @author mrnov
 */

/*
PATRÓN CREACIONAL

Abstract Factory es un patrón de diseño creacional que resuelve el problema de 
crear familias enteras de productos sin especificar sus clases concretas.

El patrón Abstract Factory define una interfaz para crear todos los productos, 
pero deja la propia creación de productos para las clases de fábrica concretas. 
Cada tipo de fábrica se corresponde con cierta variedad de producto.

El código cliente invoca los métodos de creación de un objeto de fábrica en lugar 
de crear los productos directamente con una llamada al constructor (operador new). 
Como una fábrica se corresponde con una única variante de producto, todos sus productos serán compatibles.

El código cliente trabaja con fábricas y productos únicamente a través de sus interfaces abstractas. 
Esto permite al mismo código cliente trabajar con productos diferentes. 
Simplemente, creas una nueva clase fábrica concreta y la pasas al código cliente.
*/

/*
Ejemplos de uso: 
El patrón Abstract Factory es muy común en el código Java. Muchos frameworks y bibliotecas 
lo utilizan para proporcionar una forma de extender y personalizar sus componentes estándar.

Aquí tienes algunos ejemplos de las principales bibliotecas de Java:

javax.xml.parsers.DocumentBuilderFactory#newInstance()

javax.xml.transform.TransformerFactory#newInstance()

javax.xml.xpath.XPathFactory#newInstance()

Identificación: El patrón es fácil de reconocer por los métodos, 
que devuelven un objeto de fábrica. Después, la fábrica se utiliza para
crear subcomponentes específicos.
*/

/*
Familias de componentes GUI multiplataforma y su producción
En este ejemplo, los botones y las casillas actuarán como productos. Tienen dos variantes: macOS y Windows.

La fábrica abstracta define una interfaz para crear botones y casillas. 
Hay dos fábricas concretas, que devuelven ambos productos en una única variante.

El código cliente funciona con fábricas y productos utilizando interfaces abstractas. 
Esto permite al código cliente funcionar con cualquier variante de producto creada por el objeto de fábrica.
*/

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
