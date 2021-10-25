/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros.ejercicios;

/**
 *
 * @author mrnov
 */
import java.io.*;

/*
Debemos tener en cuenta que es posible que experimentemos un problema en el caso
de que insertemos un objeto mas a un fichero binario que contenga 
objetos serializados, este no sera leído. La pregunta es ¿Porque? La respuesta es que cuando escribimos un objeto en un fichero binario ObjectOutputStream crea una cabecera al principio y cuando cerramos el fichero y volvemos a añadir un objeto crea de nuevo una cabecera, haciendo que la información a partir de esta no pueda ser leída.

Para conseguir que no cree esta cabecera debemos crear una versión de la clase
ObjectOutputStream, sobrescribiendo el método que crea esta cabecera, 
es mas fácil de lo que parece. Veamos como seria:
*/
 
//Esta clase hereda sus propiedades de ObjectOutputStream
public class MiObjectOutputStream extends ObjectOutputStream  {
 
    //Sobrescribimos el método que crea la cabecera
    protected void writeStreamHeader() throws IOException
    {
        // No hacer nada.
    }
 
    //Constructores
 
    public MiObjectOutputStream () throws IOException{
        super();
    }
    public MiObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }
    
    /*
    La idea es que si el fichero binario NO existe, usaremos la clase original y 
    si existe usamos nuestra clase creada antes. 
    
    Para indicar si existe o no un fichero, se puede usar el método exists() de la clase File.
    */
}