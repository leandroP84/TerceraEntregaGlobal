import Entidades.Domicilio;
import Entidades.Persona;
import Servicios.SERVICIO_persona;

public class CREATOR {

    Persona persona;
    Domicilio domicilio;

    public Persona create_and_save_persona(int edad , String nombre) throws Exception {
        persona = new Persona(nombre, edad);
        SERVICIO_persona s = new SERVICIO_persona();
        s.save(persona);
        return persona;
    };

}
