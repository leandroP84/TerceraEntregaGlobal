package Servicios;

import DAO.DaoGenerico;

public abstract class AbstractGenericService<T> implements ServicioGenerico<T> {

    //El abstract Service nos sirve para que el DAO hago el trabajo por detras
    //Basicamente nos sirve para llamar a persona y domicilio y crear los datos
    // seria asi
    // SERVICIO_persona juancito = new SERVICIO_Persona
    protected abstract DaoGenerico<T> getDAO();

    @Override
    public void save(T entity) throws Exception {
        getDAO().save(entity);
    }

    @Override
    public T findById(int id) throws Exception {
        return getDAO().findById(id);
    }

    @Override
    public void update(T entity) throws Exception {
        getDAO().update(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        getDAO().delete(id);
    }
}

