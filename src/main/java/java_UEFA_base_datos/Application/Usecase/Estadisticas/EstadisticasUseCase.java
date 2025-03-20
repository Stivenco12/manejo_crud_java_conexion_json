package java_UEFA_base_datos.Application.Usecase.Estadisticas;

import java.util.List;

import java_UEFA_base_datos.Domain.Entity.Equipos;
import java_UEFA_base_datos.Domain.Entity.Estadisticas;
import java_UEFA_base_datos.Domain.Repository.ProductResposity;

public class EstadisticasUseCase {
    private final ProductResposity repository ;
    
    public EstadisticasUseCase(ProductResposity repository) {
        this.repository = repository;
    }

    public void registrarEstadisticas(int id,int id_equipo,int partidos_jugados, int partidos_ganados, int partidos_empatados, int partidos_perdidos,int goles_favor, int goles_contra, int goles_totales){
        Estadisticas Estadisticas = new Estadisticas(id,id_equipo,partidos_jugados, partidos_ganados,partidos_empatados,partidos_perdidos,goles_favor,goles_contra,goles_totales);
        repository.guardar(Estadisticas);
    }

    public Equipos obtenerProducto(int id) {
        return repository.buscarPorId(id);
    }

    public List<Estadisticas> listarEstadisticas() {
        return repository.listarTodos();
    }

    public void actualizarEstadisticas(int id,int id_equipo,int partidos_jugados, int partidos_ganados, int partidos_empatados, int partidos_perdidos,int goles_favor, int goles_contra, int goles_totales){
        Estadisticas Estadisticas = new Estadisticas(id,id_equipo, partidos_jugados, partidos_ganados,partidos_empatados,partidos_perdidos,goles_favor,goles_contra,goles_totales);
        repository.actualizar(Estadisticas);
    }

    public void eliminarEstadisticas(int id) {
        repository.eliminar(id);
    } 
}
