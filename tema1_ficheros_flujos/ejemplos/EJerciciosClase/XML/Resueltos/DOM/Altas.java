
package DOM;

import java.io.*;


public class Altas {
    
    public static int altas(BufferedReader br, File fichero, int nRegs)throws IOException{
        
        if(fichero.exists()){

            CPersona persona = Altas.altaPersona(br, fichero, nRegs);
        
            if(persona.getLongitud() < persona.getTamMax()){
            
                RandomAccessFile fas = new RandomAccessFile(fichero, "rw");
                    fas.seek(nRegs*persona.getTamMax());
                    fas.writeInt(persona.getClave());
                    fas.writeUTF(persona.getNombre());
                    fas.writeFloat(persona.getEdad());
     
                fas.close();
                nRegs++;
                System.out.println("-- Persona registrado con éxito --");
            
            }else System.out.println("Longitud del objeto persona inválida");
        }else System.out.println("Fichero no encontrado");
        return nRegs;
    }
    
    public static CPersona altaPersona(BufferedReader br, File fichero, int nRegs)throws IOException{

        CPersona persona = null;
       
        System.out.println("Introduce clave persona: ");
        String clave = br.readLine();
        int y = Integer.parseInt(clave);
        
        System.out.println("Introduce nombre persona: ");
        String nombre = br.readLine();
        
        System.out.println("Introduce edad persona: ");
        String edad = br.readLine();
        Float x = Float.parseFloat(edad);
        
        persona = new CPersona();
        persona.setClave(y);
        persona.setNombre(nombre);
        persona.setEdad(x);
                
        return persona;
    }
}
