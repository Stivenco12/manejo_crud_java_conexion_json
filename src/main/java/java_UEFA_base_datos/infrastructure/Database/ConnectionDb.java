package java_UEFA_base_datos.infrastructure.Database;

import java.sql.Connection;

import java.sql.SQLException;

public interface ConnectionDb {
    Connection getConexion() throws SQLException;

}
