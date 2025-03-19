package java_UEFA_base_datos.infrastructure.persistence.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;
import java_UEFA_base_datos.Domain.Entity.Product;
import java_UEFA_base_datos.Domain.Repository.ProductResposity;
import java_UEFA_base_datos.infrastructure.Database.ConnectionDb;

public class ProductRepositoryImpl implements ProductResposity {
  private final ConnectionDb connection;
    
    public ProductRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Product producto) {
        String sql = "INSERT INTO product (id, nombreproducto, stock) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, producto.getId());
            stmt.setString(2, producto.getNombre());
            stmt.setInt(3, producto.getStock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipos buscarPorId(int id) {
            String sql = "SELECT * FROM product WHERE id = ?";
            try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.print("Id del producto = ");
                    System.out.println(rs.getInt("id"));
                    System.out.print("Nombre del producto = ");
                    System.out.println(rs.getString("NombreProducto"));
                    System.out.print("Stock del producto = ");
                    System.out.println(rs.getString("Stock"));
                    System.out.println("");
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
    public List<Product> listarTodos() {
        List<Product> pruductos = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.print("Id del Producto = ");
                System.out.println(rs.getInt("id"));
                System.out.print("Nombre del producto = ");
                System.out.println(rs.getString("NombreProducto"));
                System.out.print("Stock del producto = ");
                System.out.println(rs.getString("Stock"));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pruductos;
    }

    @Override
    public void actualizar(Product producto) {
        String sql = "UPDATE product SET NombreProducto = ?, Stock = ? WHERE Id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getStock());
            stmt.setInt(3, producto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String sql1 = "DELETE FROM product WHERE id = ?";
                try (Connection conexion1 = connection.getConexion();
                     PreparedStatement stmt1 = conexion1.prepareStatement(sql1)) {
                    stmt1.setInt(1, id);
                    stmt1.executeUpdate();
                    System.out.println("producto Eliminado exitosamente");
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
