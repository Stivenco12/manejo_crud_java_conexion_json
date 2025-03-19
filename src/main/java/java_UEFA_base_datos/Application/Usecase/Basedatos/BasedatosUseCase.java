package java_UEFA_base_datos.Application.Usecase.Basedatos;

import java_UEFA_base_datos.Domain.Repository.basedatos;

public class BasedatosUseCase {
    private final basedatos repository;

    public BasedatosUseCase(basedatos basedatos) {
        this.repository =  basedatos;
    }

    public void creardatos (){
        repository.crearbase(null);
    }
    public void crearTabla(){
        repository.crearTabla(repository);
    }
}
