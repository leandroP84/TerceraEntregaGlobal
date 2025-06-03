package Servicios;

import DAO.DAO_domicilio;
import DAO.DaoGenerico;
import Entidades.Domicilio;

public class SERVICIO_domicilio extends AbstractGenericService<Domicilio> {

    private final DAO_domicilio domicilioDAO = new DAO_domicilio();

    @Override
    protected DaoGenerico<Domicilio> getDAO() {
        return domicilioDAO;
    }
}

