/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bridge;

import Bridge.devices.Device;
import Bridge.devices.Radio;
import Bridge.devices.Tv;
import Bridge.remotes.AdvancedRemote;
import Bridge.remotes.BasicRemote;

/*
Bridge es un patrón de diseño estructural que te permite dividir una clase grande, 
o un grupo de clases estrechamente relacionadas, en 
dos jerarquías separadas (abstracción e implementación) que pueden desarrollarse independientemente la una de la otra.
*/

/*
Bridge es un patrón de diseño estructural que divide la lógica de negocio o
una clase muy grande en jerarquías de clases separadas que se pueden desarrollar independientemente.

Una de estas jerarquías (a menudo denominada Abstracción) 
obtendrá una referencia a un objeto de la segunda jerarquía (Implementación). 
La abstracción podrá delegar algunas (en ocasiones, la mayoría) 
de sus llamadas al objeto de las implementaciones. 
Como todas las implementaciones tendrán una interfaz común, serán intercambiables dentro de la abstracción.


Uso del patrón en Java

Ejemplos de uso: El patrón Bridge es de especial utilidad a la hora de tratar 
con aplicaciones multiplataforma, soportar varios tipos de servidores de bases de datos, 
o trabajar con varios proveedores de API de un cierto tipo (por ejemplo, 
plataformas en la nube, redes sociales, etc.).

Identificación: El patrón Bridge se puede reconocer por una distinción clara entre 
alguna entidad controladora y varias plataformas diferentes de las que depende.
*/


/**
 *
 * @author mrnov
 */

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
