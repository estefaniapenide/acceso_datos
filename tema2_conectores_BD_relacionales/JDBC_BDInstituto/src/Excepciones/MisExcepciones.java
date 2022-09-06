

package Excepciones;

/**
 *
 * @author mrnovoa
 */
public class MisExcepciones {
    
    public static boolean validarDNI(String dni) {

        boolean b = false;

        try {
            if (dni.length() != 9) {

                throw new Excepciones("Error, longitud erronea.");

            } else {

                if (!dni.substring(0, 8).matches("[0-9]*")) {

                    throw new Excepciones("Error, los 8 primeros dígitos deben ser números");
                } else {
                    if (!dni.substring(8).matches("[A-Za-z]")) {

                        throw new Excepciones("Error, el último dígito debe ser una letra");

                    } else {

                        b = true;
                    }
                }
            }

        } catch (Excepciones e) {

            System.out.println(e.getMessage());

        }

        return b;

    }
    
    public static boolean validarCodigo(String codigo) {

        boolean b = false;

        try {
            if (codigo.length() != 4) {

                throw new Excepciones("Error, longitud erronea.");

            } else {

                if (!codigo.substring(0, 3).matches("[0-9]*")) {

                    throw new Excepciones("Error, los 8 primeros dígitos deben ser números");
                } else {
                    if (!codigo.substring(3).matches("[A-Za-z]")) {

                        throw new Excepciones("Error, el último dígito debe ser una letra");

                    } else {

                        b = true;
                    }
                }
            }

        } catch (Excepciones e) {

            System.out.println(e.getMessage());

        }

        return b;

    }
    
    public static boolean validarNota(float nota) {

        boolean b = false;

        try {
            if (nota < 0 || nota > 10) {

                throw new Excepciones("Error, debe ser un número entre 0 y 10.");

            } else {

                b = true;
                    
                
            }

        } catch (Excepciones e) {

            System.out.println(e.getMessage());

        }

        return b;

    }
}
