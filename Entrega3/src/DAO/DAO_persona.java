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
        //aqui tendria que estar domicilio ?
        return persona;
    }

    @Override
    protected void setUpdateParams(PreparedStatement stmt, Persona persona) throws SQLException {
        stmt.setString(1, persona.nombre);
        stmt.setInt(2, persona.edad);
        stmt.setInt(3, persona.id);
        // El stmt hace esto → "UPDATE persona SET nombre = ?, edad = ? WHERE id = ?"
    }

    @Override
    protected int getEntityId(Persona persona) {
        return persona.id;
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE persona SET nombre = ?, edad = ? WHERE id = ?";
    }


    @Override
    protected String getInsertQuery() {
        return "INSERT INTO persona (nombre, edad,Domicilio_fk) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParams(PreparedStatement stmt, Persona persona) throws SQLException {
        stmt.setString(1, persona.nombre);
        stmt.setInt(2, persona.edad);
        stmt.setInt(3, persona.domicilio.id);

        // El stmt hace esto → "UPDATE persona SET nombre = ?, edad = ? WHERE id = ?"
        //1 es el primer (?) y 2 el segundo (?)

        //"   if (persona.nombre == null || persona.nombre.trim().isEmpty()) {throw new SQLException("El nombre de la persona no puede estar vacío");}
        //    if (persona.edad == null || persona.edad < 0 || persona.edad > 120) {throw new SQLException("Edad inválida. Debe ser entre 0 y 120");}"
    }

    @Override
    protected void setGeneratedId(ResultSet rs, Persona persona) throws SQLException {
        persona.id = rs.getInt(1);
    }
}
