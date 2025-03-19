package java_UEFA_base_datos.infrastructure.Database;

public class ConnectionFactory {
    public static ConnectionDb crearConexion(){
        
        return new ConnMySql();
        
    }
}
