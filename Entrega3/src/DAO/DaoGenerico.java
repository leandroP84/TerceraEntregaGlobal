package DAO;

import java.util.List;

public interface DaoGenerico<T> {
    void save(T entity);
    T findById(int id);
    void update(T entity);
    void delete(int id);
}
