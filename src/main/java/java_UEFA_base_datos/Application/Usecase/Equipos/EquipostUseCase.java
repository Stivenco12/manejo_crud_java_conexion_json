package java_UEFA_base_datos.Application.Usecase.Equipos;

import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;
import java_UEFA_base_datos.Domain.Repository.ClientRespository;

public class EquipostUseCase {
    private final ClientRespository repository;

    public EquipostUseCase(ClientRespository repository) {
        this.repository = repository;
    }
    public void registrarEquipo(int id, String name, int año_fundacion, String entrenador){
        Equipos equipo = new Equipos(id, name, año_fundacion, entrenador);
        repository.guardar(equipo);
    }
    public Equipos obtenerEquipos(int id) {
        return repository.buscarPorId(id);
    }

    public List<Equipos> listarClientes() {
        return repository.listarTodos();
    }

    public void actualizarEquipos(int id, String name, int año_fundacion, String entrenador) {
        Equipos equipos = new Equipos(id, name, año_fundacion, entrenador);
        repository.actualizar(equipos);
    }

    public void eliminarCliente(int id) {
        repository.eliminar(id);
    }
}
