/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_filtro.modelo;

/**
 *
 * @author Uniminuto Tibu
 */
public class verMisionesCompletadas {
    private int id_ninja;
    private String nombre;
    private String rangoNinja;
    private String aldea;
    private int id_mision_ninja;
    private String fechaInicio;
    private String fechaFin;
    private int id_mision;
    private String description;
    private String rangoMision;
    private int recompensa;

    public verMisionesCompletadas() {
    }

    public verMisionesCompletadas(int id_ninja, String nombre, String rangoNinja, String aldea, int id_mision_ninja, String fechaInicio, String fechaFin, int id_mision, String description, String rangoMision, int recompensa) {
        this.id_ninja = id_ninja;
        this.nombre = nombre;
        this.rangoNinja = rangoNinja;
        this.aldea = aldea;
        this.id_mision_ninja = id_mision_ninja;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id_mision = id_mision;
        this.description = description;
        this.rangoMision = rangoMision;
        this.recompensa = recompensa;
    }
    
    public int getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRangoNinja() {
        return rangoNinja;
    }

    public void setRangoNinja(String rangoNinja) {
        this.rangoNinja = rangoNinja;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    public int getId_mision_ninja() {
        return id_mision_ninja;
    }

    public void setId_mision_ninja(int id_mision_ninja) {
        this.id_mision_ninja = id_mision_ninja;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRangoMision() {
        return rangoMision;
    }

    public void setRangoMision(String rangoMision) {
        this.rangoMision = rangoMision;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
}
