package mvc_filtro.modelo;

public class completarMision {
    private int id_mision_ninja;
    private String fecha_fin;

    public completarMision() {
    }

    public completarMision(int id_mision_ninja, String fecha_fin) {
        this.id_mision_ninja = id_mision_ninja;
        this.fecha_fin = fecha_fin;
    }

    public int getId_mision_ninja() {
        return id_mision_ninja;
    }

    public void setId_mision_ninja(int id_mision_ninja) {
        this.id_mision_ninja = id_mision_ninja;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
