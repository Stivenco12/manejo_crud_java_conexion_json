package java_UEFA_base_datos.Application.Usecase.Product;

import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;
import java_UEFA_base_datos.Domain.Entity.Product;
import java_UEFA_base_datos.Domain.Repository.ProductResposity;

public class ProductUseCase {
    private final ProductResposity repository ;
    
    public ProductUseCase(ProductResposity repository) {
        this.repository = repository;
    }

    public void registrarProducto(int id, String nombre, int stock){
        Product product = new Product(id, nombre, stock);
        repository.guardar(product);
    }

    public Equipos obtenerProducto(int id) {
        return repository.buscarPorId(id);
    }

    public List<Product> listarProducts() {
        return repository.listarTodos();
    }

    public void actualizarProducto(int id, String nombre, int stock) {
        Product product = new Product(id, nombre, stock);
        repository.actualizar(product);
    }

    public void eliminarProducto(int id) {
        repository.eliminar(id);
    } 
}
