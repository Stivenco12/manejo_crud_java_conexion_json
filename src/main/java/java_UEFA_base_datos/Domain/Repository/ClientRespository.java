package java_UEFA_base_datos.Domain.Repository;

import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;

public interface ClientRespository {
    void guardar(Equipos equipos);
    Equipos buscarPorId(int id);
    List<Equipos> listarTodos();
    void actualizar(Equipos equipos);
    void eliminar(int id);
}
