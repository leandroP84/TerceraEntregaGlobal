package DAO;

import Entidades.Domicilio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_domicilio extends AbstractGenericDAO<Domicilio> {

    @Override
    protected String getTableName() {
        return "domicilio";
    }

    @Override
    protected String getIdColumn() {
        return "id";
    }

    @Override
    protected Domicilio mapResult(ResultSet rs) throws SQLException {
        Domicilio domicilio = new Domicilio(
                rs.getString("calle"),
                rs.getInt("numero"),
                rs.getString("localidad")
        );
        domicilio.id = rs.getInt("id");
        return domicilio;
    }

    @Override
    protected void setUpdateParams(PreparedStatement stmt, Domicilio domicilio) throws SQLException {
        stmt.setString(1, domicilio.calle);
        stmt.setInt(2, domicilio.numero);
        stmt.setString(3, domicilio.localidad);
        stmt.setInt(4, domicilio.id);
    }

    @Override
    protected int getEntityId(Domicilio domicilio) {
        return domicilio.id;
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE domicilio SET calle = ?, numero = ?, localidad = ? WHERE id = ?";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO domicilio (calle, numero, localidad) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParams(PreparedStatement stmt, Domicilio domicilio) throws SQLException {
        stmt.setString(1, domicilio.calle);
        stmt.setInt(2, domicilio.numero);
        stmt.setString(3, domicilio.localidad);
    }

    @Override
    protected void setGeneratedId(ResultSet rs, Domicilio domicilio) throws SQLException {
        domicilio.id = rs.getInt(1);
    }

    //for each + retornar tipo de Dato medio rebuscado pero posible.
}
