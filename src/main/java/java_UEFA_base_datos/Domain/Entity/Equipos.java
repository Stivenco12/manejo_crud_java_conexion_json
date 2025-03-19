package java_UEFA_base_datos.Domain.Entity;

public class Equipos {
    private int id;
    private String name;
    private int año_fundacion ;
    private String entrenador ;
    public Equipos(int id, String name, int año_fundacion, String entrenador ){
        this.id = id;
        this.name = name;
        this.año_fundacion  = año_fundacion ;
        this.entrenador = entrenador;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public int getAño_fundacion() {
        return año_fundacion;
    }

    public void setAño_fundacion(int año_fundacion) {
        this.año_fundacion = año_fundacion;
    } 
    
}
