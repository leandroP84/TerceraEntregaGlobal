import Entidades.Persona;
import Entidades.Domicilio;
import Servicios.SERVICIO_persona;
import Servicios.SERVICIO_domicilio;

public class main {

    public static void main(String[] args) {
        try {
            SERVICIO_persona persona_s = new SERVICIO_persona();
            SERVICIO_domicilio domicilio_s = new SERVICIO_domicilio();

            // Crear y guardar Persona
            Persona persona = new Persona("Marge", 38);
            persona_s.save(persona);
            System.out.println("Persona guardada con ID: " + persona.id);

            // Crear y guardar Domicilio
            Domicilio domicilio = new Domicilio("Evergreen Terrace", 742, "Springfield");
            domicilio_s.save(domicilio);
            System.out.println("Domicilio guardado con ID: " + domicilio.id);

            // Buscar Persona por ID
            Persona personaBuscada = persona_s.findById(persona.id);
            System.out.println("Persona encontrada: " + personaBuscada.nombre + ", edad: " + personaBuscada.edad);

            // Buscar Domicilio por ID
            Domicilio domicilioBuscado = domicilio_s.findById(domicilio.id);
            System.out.println("Domicilio encontrado: " + domicilioBuscado.calle + " " + domicilioBuscado.numero + ", " + domicilioBuscado.localidad);

            // Actualizar Persona
            personaBuscada.edad = 39;
            persona_s.update(personaBuscada);
            System.out.println("Persona actualizada: edad = " + personaBuscada.edad);

            // Actualizar Domicilio
            domicilioBuscado.localidad = "Shelbyville";
            domicilio_s.update(domicilioBuscado);
            System.out.println("Domicilio actualizado: localidad = " + domicilioBuscado.localidad);

            // Eliminar Persona
            persona_s.delete(personaBuscada.id);
            System.out.println("Persona eliminada con ID: " + personaBuscada.id);

            // Eliminar Domicilio
            domicilio_s.delete(domicilioBuscado.id);
            System.out.println("Domicilio eliminado con ID: " + domicilioBuscado.id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

