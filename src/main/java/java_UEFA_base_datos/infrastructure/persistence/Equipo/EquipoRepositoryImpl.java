package java_UEFA_base_datos.infrastructure.persistence.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;
import java_UEFA_base_datos.Domain.Repository.ClientRespository;
import java_UEFA_base_datos.infrastructure.Database.ConnectionDb;


public class EquipoRepositoryImpl implements ClientRespository {
    private final ConnectionDb connection;
    
    public EquipoRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Equipos equipos) {
        String sql = "INSERT INTO equipos (nombre, año_fundacion, entrenador) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, equipos.getName());
                stmt.setInt(2, equipos.getAño_fundacion());  
                stmt.setString(3, equipos.getEntrenador());
            stmt.executeUpdate();
            System.out.println("Los datos han sido ingresados correctamente");
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipos buscarPorId(int id) {
        String sql = "SELECT * FROM equipos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("");
                System.out.print("Id del equipos = ");
                System.out.println(rs.getInt("id"));
                System.out.print("Nombre del equipos = ");
                System.out.println(rs.getString("nombre"));
                System.out.print("año fundacion del equipos = ");
                System.out.println(rs.getInt("año_fundacion"));
                System.out.print("entrenador del equipos = ");
                System.out.println(rs.getString("entrenador"));
                
            }else{
                System.out.println("error ese id no existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return null;
    }

    @Override
    public List<Equipos> listarTodos() {
        List<Equipos> clientes = new ArrayList<>();
        String sql = "SELECT * FROM equipos";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("");
                System.out.print("Id del equipos = ");
                System.out.println(rs.getInt("id"));
                System.out.print("Nombre del equipos = ");
                System.out.println(rs.getString("nombre"));
                System.out.print("año fundacion del equipos = ");
                System.out.println(rs.getInt("año_fundacion"));
                System.out.print("entrenador del equipos = ");
                System.out.println(rs.getString("entrenador"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void actualizar(Equipos equipos) {
        String sql = "UPDATE equipos SET nombre = ?, año_fundacion = ?, entrenador = ? WHERE Id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, equipos.getName());
            stmt.setInt(2, equipos.getAño_fundacion());
            stmt.setString(3, equipos.getEntrenador());
            stmt.setInt(4, equipos.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql0 = "SELECT * FROM equipos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql0)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String sql = "DELETE FROM equipos WHERE id = ?";
                    try (Connection conexion1 = connection.getConexion();
                        PreparedStatement stmt1 = conexion1.prepareStatement(sql)) {
                        stmt1.setInt(1, id);
                        stmt1.executeUpdate();
                        System.out.println("producto elimnado exitosamente");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("error ese id no existe");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error");
        }
    }

    
}
