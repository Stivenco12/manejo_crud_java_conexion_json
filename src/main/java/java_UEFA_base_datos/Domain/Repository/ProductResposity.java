package java_UEFA_base_datos.Domain.Repository;

import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;
import java_UEFA_base_datos.Domain.Entity.Estadisticas;

public interface ProductResposity {
    void guardar(Estadisticas producto);
    Equipos buscarPorId(int id);
    List<Estadisticas> listarTodos();
    void actualizar(Estadisticas producto);
    void eliminar(int id);
}
