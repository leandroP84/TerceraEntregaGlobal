package Servicios;

public interface ServicioGenerico<T> {
    void save(T entity) throws Exception;
    T findById(int id) throws Exception;
    void update(T entity) throws Exception;
    void delete(int id) throws Exception;
}

