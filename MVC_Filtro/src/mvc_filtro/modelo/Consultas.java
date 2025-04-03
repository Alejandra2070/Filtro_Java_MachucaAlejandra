package mvc_filtro.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consultas {
    
    Connection cx = null;
    
    String url = "jdbc:mysql://b4am2aeofy1gaitu1rhb-mysql.services.clever-cloud.com:3306/b4am2aeofy1gaitu1rhb";
    String user = "u6k39w0odsjvh8xd";
    String password = "u2iZqSYMhZHxMqX1kgGL";
    
    public Connection getConexion(){
        try{
            cx = DriverManager.getConnection(url, user, password);
            System.out.println("Se conectó a BBDD");
        }
        catch(SQLException e){
            System.out.println("No se conectó a BBDD");
        }
        return cx;
    }
    
    /*mostrar todos los ninjas*/
    public List<String> MostrarNinjas(Ninja ninja){

        String sql = "select n.*, h.descripcion from Ninja n inner join Habilidad h on n.id_ninja = h.id_ninja";
        List<String> listaNinjas = new ArrayList<>();
        try{
            Connection cx = getConexion();  
            System.out.println(cx);
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaNinjas.add( """
                                 ***************************************
                                 Id ninja: """ + rs.getInt("id_ninja")
                            + "\nNombre: " + rs.getString("nombre")
                            + "\nRango: " + rs.getString("rango")
                            + "\nAldea: " + rs.getString("aldea") 
                            +"\nHabilidad: " + rs.getString("descripcion") +"\n");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaNinjas;
    }
    
    /*mostrar las misiones disponibles para un ninja*/
    public List<String> MisionesDisponibles(misionesDisponibles md){
        
        String sql = """
                    select n.*, mn.id_mision_ninja, mn.fechaInicio, mn.fechaFin, m.* from MisionNinja mn
                    inner join Mision m on m.id_mision = mn.id_mision
                    inner join Ninja n on n.id_ninja = mn.id_ninja
                    where mn.fechaFin > current_date() and n.id_ninja = ?""";
        List<String> listaMisiones = new ArrayList<>();
        try{
            Connection cx = getConexion();
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, md.getId_ninja());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaMisiones.add("/n" + "Id ninja: " + rs.getInt("id_ninja")
                            + "/n" + "Nombre: " + rs.getString("nombre")
                            + "/n"+ "Rango: " +  rs.getString("rango")
                            + "/n"+ "Aldea: " +  rs.getString("aldea")
                            + "/n"+ "Id misión: " +  rs.getInt("id_mision")
                            + "/n"+ "Descripción: " +  rs.getString("descripcion")
                            + "/n"+ "Rango aldea: " +  rs.getString("rango")
                            + "/n"+ "Recompensa: " +  rs.getString("recompensa")
                            + "/n"+ "Fecha de inicio: " +  rs.getString("fechaInicio")
                            + "/n"+ "Fecha de finalización: " +  rs.getString("fechaFin"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaMisiones;   
    }
    
    /*mostrar las misiones completadas para un ninja*/
    public List<String> MisionesCompletadas(misionesDisponibles md){
        
        String sql = """
                    select n.*, mn.id_mision_ninja, mn.fechaInicio, mn.fechaFin, m.* from MisionNinja mn
                    inner join Mision m on m.id_mision = mn.id_mision
                    inner join Ninja n on n.id_ninja = mn.id_ninja
                    where mn.fechaFin < current_date() and n.id_ninja = ?""";
        List<String> listaMisiones = new ArrayList<>();
        try{
            Connection cx = getConexion();
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, md.getId_ninja());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaMisiones.add("/n" + "Id ninja: " + rs.getInt("id_ninja")
                            + "/n" + "Nombre: " + rs.getString("nombre")
                            + "/n"+ "Rango: " +  rs.getString("rango")
                            + "/n"+ "Aldea: " +  rs.getString("aldea")
                            + "/n"+ "Id misión: " +  rs.getInt("id_mision")
                            + "/n"+ "Descripción: " +  rs.getString("descripcion")
                            + "/n"+ "Rango aldea: " +  rs.getString("rango")
                            + "/n"+ "Recompensa: " +  rs.getString("recompensa")
                            + "/n"+ "Fecha de inicio: " +  rs.getString("fechaInicio")
                            + "/n"+ "Fecha de finalización: " +  rs.getString("fechaFin"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaMisiones;   
    }
    
    /*asignar una misión a un ninja registrando la fecha de inicio*/
    public boolean asignarMision(asignarMision asigM){
        PreparedStatement ps = null;
        Connection cx = getConexion();
        
        String sql = "insert into MisionNinja (fechaInicio, id_ninja, id_mision) values (?,?,?)";
        
        try{
            ps = cx.prepareStatement(sql);
            ps.setString(1, asigM.getFecha_inicio());
            ps.setInt(2, asigM.getId_ninja());
            ps.setInt(3, asigM.getId_mision());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                cx.close();
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    /*marcar una misión como completada registrando fecha de finalización*/
    public boolean completarMision(completarMision compM){
        PreparedStatement ps = null;
        Connection cx = getConexion();
        
        String sql = "update MisionNinja set fechaFin=? where id_mision_ninja = ?";
        
        try{
            ps = cx.prepareStatement(sql);
            ps.setString(1, compM.getFecha_fin());
            ps.setInt(2, compM.getId_mision_ninja());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                cx.close();
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    /*ver todas las misiones completadas*/
    public List<String> todasMisionesCompletadas(verMisionesCompletadas vmc){
        
        String sql = """
                    select n.*, mn.id_mision_ninja, mn.fechaInicio, mn.fechaFin, m.* from MisionNinja mn
                    inner join Mision m on m.id_mision = mn.id_mision
                    inner join Ninja n on n.id_ninja = mn.id_ninja
                    where mn.fechaFin < current_date()""";
        List<String> listaCompletas = new ArrayList<>();
        try{
            Connection cx = getConexion();
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaCompletas.add("/n" + "Id ninja: " + rs.getInt("id_ninja")
                            + "/n" + "Nombre: " + rs.getString("nombre")
                            + "/n"+ "Rango: " +  rs.getString("rango")
                            + "/n"+ "Aldea: " +  rs.getString("aldea")
                            + "/n"+ "Id misión: " +  rs.getInt("id_mision")
                            + "/n"+ "Descripción: " +  rs.getString("descripcion")
                            + "/n"+ "Rango aldea: " +  rs.getString("rango")
                            + "/n"+ "Recompensa: " +  rs.getString("recompensa")
                            + "/n"+ "Fecha de inicio: " +  rs.getString("fechaInicio")
                            + "/n"+ "Fecha de finalización: " +  rs.getString("fechaFin"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaCompletas;   
    }
}
