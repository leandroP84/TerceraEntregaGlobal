package DAO;

import ConfiguracionDeLaBase.DBconecion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractGenericDAO<T> implements DaoGenerico<T> {

    protected abstract String getTableName();
    protected abstract String getIdColumn();
    protected abstract T mapResult(ResultSet rs) throws SQLException;
    protected abstract void setUpdateParams(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract int getEntityId(T entity);
    protected abstract String getUpdateQuery();

    // 🔥 Nuevos métodos abstractos para SAVE
    protected abstract String getInsertQuery();
    protected abstract void setInsertParams(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract void setGeneratedId(ResultSet rs, T entity) throws SQLException;

    @Override
    public T findById(int id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumn() + " = ?";
        T result = null;

        try (Connection conn = DBconecion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = mapResult(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void update(T entity) {
        String sql = getUpdateQuery();

        try (Connection conn = DBconecion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            setUpdateParams(stmt, entity);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumn() + " = ?";

        try (Connection conn = DBconecion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ save() genérico reutilizable
    @Override
    public void save(T entity) {
        String sql = getInsertQuery();

        try (Connection conn = DBconecion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            setInsertParams(stmt, entity);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    setGeneratedId(rs, entity);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
