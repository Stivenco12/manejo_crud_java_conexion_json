package java_UEFA_base_datos.Domain.Entity;

public class Estadisticas {
    private int id;
    private int id_equipo;
    private int partidos_jugados;
    private int partidos_ganados;
    private int partidos_empatados;
    private int partidos_perdidos;
    private int goles_favor;
    private int goles_contra;
    private int goles_totales;
    
    public Estadisticas(int id,int id_equipo,int partidos_jugados, int partidos_ganados, int partidos_empatados, int partidos_perdidos,int goles_favor, int goles_contra, int goles_totales) {
        this.id = id;
        this.id_equipo = id_equipo;
        this.partidos_jugados = partidos_jugados;
        this.partidos_ganados = partidos_ganados;
        this.partidos_empatados = partidos_empatados;
        this.partidos_perdidos = partidos_perdidos;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
        this.goles_totales = goles_totales;
    }
    public int getid(){
        return id;
    }
    
    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public int getId_equipo() {
        return id_equipo;
    }
    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public int getPartidos_empatados() {
        return partidos_empatados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }

    public int getGoles_favor() {
        return goles_favor;
    }

    public int getGoles_contra() {
        return goles_contra;
    }

    public int getGoles_totales() {
        return goles_totales;
    }

    public void setid(int id){
        this.id = id;
    }
    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }
    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public void setPartidos_empatados(int partidos_empatados) {
        this.partidos_empatados = partidos_empatados;
    }

    public void setPartidos_perdidos(int partidos_perdidos) {
        this.partidos_perdidos = partidos_perdidos;
    }

    public void setGoles_favor(int goles_favor) {
        this.goles_favor = goles_favor;
    }

    public void setGoles_contra(int goles_contra) {
        this.goles_contra = goles_contra;
    }

    public void setGoles_totales(int goles_totales) {
        this.goles_totales = goles_totales;
    }

    
}
