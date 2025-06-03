package DAO;

import Entidades.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_persona extends AbstractGenericDAO<Persona> {

    @Override
    protected String getTableName() {
        return "persona";
    }

    @Override
    protected String getIdColumn() {
        return "id";
    }

    @Override
    protected Persona mapResult(ResultSet rs) throws SQLException {
        Persona persona = new Persona(rs.getString("nombre"), rs.getInt("edad"));
        persona.id = rs.getInt("id");
        return persona;
    }

    @Override
    protected void setUpdateParams(PreparedStatement stmt, Persona persona) throws SQLException {
        stmt.setString(1, persona.nombre);
        stmt.setInt(2, persona.edad);
        stmt.setInt(3, persona.id);
    }

    @Override
    protected int getEntityId(Persona persona) {
        return persona.id;
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE persona SET nombre = ?, edad = ? WHERE id = ?";
    }

    // 🔽 Nuevos métodos para INSERT

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO persona (nombre, edad) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParams(PreparedStatement stmt, Persona persona) throws SQLException {
        stmt.setString(1, persona.nombre);
        stmt.setInt(2, persona.edad);
    }

    @Override
    protected void setGeneratedId(ResultSet rs, Persona persona) throws SQLException {
        persona.id = rs.getInt(1);
    }
}
