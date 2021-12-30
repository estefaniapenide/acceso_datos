package singleton;
/*
PATRÓN CREACIONAL

En el patrón de diseño Sigleton, se reduce o limita el número de objetos que ha de crearse a solo uno. 
Igual que las variables estáticas solamente existirá un objeto por clase.

Utilice este patrón cuando vayan a realizarse:
- conexiones a bases de datos o 
- a programar sockets. 
De esta forma, se centrará en el acceso al recurso y controlará el número de sesiones activas o conexiones.

*/
public class RootUserSingleton {

    private int UID = 0;
    private int GID = 0;
    private String userName = "root";
    private String name = "Super user";
    private String home = "/root";
    private String shell = "/bin/sh";

    private static RootUserSingleton instance = null;

    private RootUserSingleton() {
        //este método existe para evitar la instanciación
    }

    //se utiliza el método getInstance para controlar instanciación
    //sólo existirá un objeto único para la clase
    public static RootUserSingleton getInstance() {
        if (instance == null) {
            instance = new RootUserSingleton();
        }
        return instance;
    }

    //se definen los distintos métodos dela clase singleton
    protected static void dimeAlgo(){
        System.out.println("Método de la clase singleton");
    }
    
    @Override
    public String toString() {
        return new StringBuilder(userName)
                .append("(").append(name).append(")")
                .append(" ").append(UID).append(":").append(GID)
                .append(" home: ").append(home).append(" ")
                .append("shell: ").append(shell)
                .toString();
    }
}
