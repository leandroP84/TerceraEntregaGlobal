package Servicios;

import DAO.DaoGenerico;

public abstract class AbstractGenericService<T> implements ServicioGenerico<T> {

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

