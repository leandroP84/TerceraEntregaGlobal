package Servicios;

import DAO.DAO_persona;
import DAO.DaoGenerico;
import Entidades.Persona;

public class SERVICIO_persona extends AbstractGenericService<Persona> {

    private final DAO_persona personaDAO = new DAO_persona();

    @Override
    protected DaoGenerico<Persona> getDAO() {
        return personaDAO;
    }

     //@Override
     //public void save(Persona entity) throws Exception
    //{
        //entity. REVISAR TARDE

     // }
    //validacion falta
}

