package java_UEFA_base_datos.infrastructure.Database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java_UEFA_base_datos.Config.HexaSingleton;


public class ConnMySql implements ConnectionDb {
    public class UEFA {
        public static String UEFA = "";
    }
    @Override
    public Connection getConexion() throws SQLException{
      
        HexaSingleton config = HexaSingleton.INSTANCIA;
        String url = "jdbc:mysql://localhost:3306/"+ UEFA.UEFA;
        String usuario = config.get("db.user");
        String password = config.get("db.pasword");
        
        return DriverManager.getConnection(url,usuario,password);
    }
}
