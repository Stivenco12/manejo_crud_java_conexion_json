package java_UEFA_base_datos.Domain.Repository;

import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;
import java_UEFA_base_datos.Domain.Entity.Product;

public interface ProductResposity {
    void guardar(Product producto);
    Equipos buscarPorId(int id);
    List<Product> listarTodos();
    void actualizar(Product producto);
    void eliminar(int id);
}
