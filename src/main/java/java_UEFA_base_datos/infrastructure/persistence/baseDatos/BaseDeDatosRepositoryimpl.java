package java_UEFA_base_datos.infrastructure.persistence.baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java_UEFA_base_datos.Domain.Entity.BaseDeDatos;
import java_UEFA_base_datos.Domain.Repository.basedatos;
import java_UEFA_base_datos.infrastructure.Database.ConnectionDb;
import java_UEFA_base_datos.infrastructure.Database.ConnMySql.UEFA;

public class BaseDeDatosRepositoryimpl implements basedatos{
     private final ConnectionDb connection;
    
    public BaseDeDatosRepositoryimpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void crearbase(BaseDeDatos BaseDeDatos) {

        String sql = "CREATE DATABASE UEFA; ";
        try(Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.executeUpdate();
            UEFA.UEFA = "UEFA";
        }catch(SQLException e){
        }

        String sql2 = "CREATE TABLE equipos(Id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50), año_fundacion YEAR, entrenador VARCHAR(50));";
        try(Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql2)){
            stmt.executeUpdate();
        }catch(SQLException e){
        }

        String sql3 = "CREATE TABLE estadisticas (id INT PRIMARY KEY AUTO_INCREMENT, equipo_id INT, partidos_jugados INT,partidos_ganados INT ,partidos_empatados INT ,partidos_perdidos INT ,goles_favor INT ,goles_contra INT ,puntos INT ,FOREIGN KEY (equipo_id) REFERENCES equipos(id) ON DELETE CASCADE);";
        try(Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql3)){
            stmt.executeUpdate();
        }catch(SQLException e){
        }
        return;

        
    }
    @Override
    public void crearTabla(basedatos basedatos) {
        String sq = "CREATE TABLE jugadores (id INT PRIMARY KEY AUTO_INCREMENT, equipo_id INT NOT NULL,dorsal INT NOT NULL,nombre VARCHAR(100) NOT NULL,nacionalidad VARCHAR(50) NOT NULL,edad INT NOT NULL,altura INT NOT NULL,peso INT NOT NULL,posicion VARCHAR(50) NOT NULL,FOREIGN KEY (equipo_id) REFERENCES equipos(id) ON DELETE CASCADE);";
        try(Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sq)){
            stmt.executeUpdate();
        }catch(SQLException e){
        }
        return;

    }

}