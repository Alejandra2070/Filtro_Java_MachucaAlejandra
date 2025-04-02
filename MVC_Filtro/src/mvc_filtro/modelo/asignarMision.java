package mvc_filtro.modelo;

public class asignarMision {
    private String fecha_inicio;
    private int id_ninja;
    private int id_mision;

    public asignarMision() {
    }

    public asignarMision(String fecha_inicio, int id_ninja, int id_mision) {
        this.fecha_inicio = fecha_inicio;
        this.id_ninja = id_ninja;
        this.id_mision = id_mision;
    }

    public int getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }
}
