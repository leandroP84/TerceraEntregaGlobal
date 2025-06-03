import Entidades.Persona;
import Entidades.Domicilio;
import Servicios.SERVICIO_persona;
import Servicios.SERVICIO_domicilio;

import java.io.PipedWriter;

public class main {

    public static void main(String[] args) {
        try {
            //invocamos el queryManipulator
            SERVICIO_persona persona_s = new SERVICIO_persona();
            SERVICIO_domicilio domicilio_s = new SERVICIO_domicilio();


            //CREATOR cp = new CREATOR();

            //Persona persona = cp.create_and_save_persona(45,"Doctor Casa");

            // Crear y guardar Persona

            //Persona persona = new Persona("Francisco", 22); //Creamos a una Persona para pasarla como parametro al service persona
           // persona_s.save(persona); //  usamos el service persona_s.save(Persona persona) para guardar al de arriba
           // System.out.println("Persona guardada con ID: " + persona.id);

            // Crear y guardar Domicilio
          // Domicilio domicilio = new Domicilio("Doctor House", 102, "Yankilandia ");
          // domicilio_s.save(domicilio);
          // System.out.println("Domicilio guardado con ID: " + domicilio.id);

            // Buscar Persona por ID
           // Persona personaBuscada = persona_s.findById(persona.id);
            //System.out.println("Persona encontrada: " + personaBuscada.nombre + ", edad: " + personaBuscada.edad);

            // Buscar Domicilio por ID
           // Domicilio domicilioBuscado = domicilio_s.findById(domicilio.id);
            //System.out.println("Domicilio encontrado: " + domicilioBuscado.calle + " " + domicilioBuscado.numero + ", " + domicilioBuscado.localidad);

            // Actualizar Persona
            //personaBuscada.edad = 739;
           // persona_s.update(personaBuscada);
            //System.out.println("Persona actualizada: edad = " + personaBuscada.edad);

            // Actualizar Domicilio
            //domicilioBuscado.localidad = "se actualizo???";
            //domicilio_s.update(domicilioBuscado);
            //System.out.println("Domicilio actualizado: localidad = " + domicilioBuscado.localidad);

            // Eliminar Persona
            //persona_s.delete(personaBuscada.id);
            //System.out.println("Persona eliminada con ID: " + personaBuscada.id);

            // Eliminar Domicilio
            //domicilio_s.delete(domicilioBuscado.id);
            //System.out.println("Domicilio eliminado con ID: " + domicilioBuscado.id);


            //Probando LA TEORIA 2


            Domicilio invento = new Domicilio("Doctor House", 102, "Yankilandia ");
            domicilio_s.save(invento);

            Persona doomslayer = new Persona("Doomslayer", 45); // creando al doom slayer
            doomslayer.setDomicilio(invento);

            persona_s.save(doomslayer); // guardandolo
            System.out.println("se Guardó "+ doomslayer.nombre +"  Persona guardada con ID: " + doomslayer.id);

            persona_s.delete(21);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

