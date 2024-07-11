package edu.ar.data;

import static edu.ar.data.Conexion.getConexion;
import static edu.ar.data.Conexion.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

import edu.ar.model.Pelicula;

public class PeliculaDAO {

    private static final String SQL_SELECT = "SELECT * FROM movie";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM movie WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO movie (nombre, descripcion, genero, calificacion, anio, estrellas, director) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = 
    "UPDATE movie SET nombre = ?, descripcion = ?, genero = ?, calificacion = ?, anio = ?, estrellas = ?, director = ? WHERE id = ?";
 
    private static final String SQL_DELETE = "DELETE FROM movie WHERE id = ?";

    public static List<Pelicula> obtener(){
    //el profe en el video repaso java le puso OBTENER en lugar de SELECCIONAR

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pelicula pelicula = null;
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
        
            //Itero las peliculas devueltas por la base de datos en el REsultSet
            //Obteniendo los atribs de cada eli y los seteo al los objs peliculas
            //guardo cada pelicula en el listado de pelis (ArrayList)

        while (rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String genero = rs.getString("genero");
            int calificacion = rs.getInt("calificacion");
            int anio = rs.getInt("anio");
            
            //en la base de datos tengo tinyint
            byte estrellas = rs.getByte("estrellas");
            String director = rs.getString("director");


            pelicula = new Pelicula(id, nombre, descripcion, genero, calificacion, anio, estrellas, director);

            peliculas.add(pelicula);
  
        }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally{
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (Exception e) {
               e.printStackTrace(System.out);
            }
        }

        return peliculas;
    }

    public static int insertar(Pelicula peli){
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, peli.getNombre());
            ps.setString(2, peli.getDescripcion());
            ps.setString(3, peli.getGenero());
            ps.setInt(4, peli.getCalificacion());
            ps.setInt(5, peli.getAnio());
            ps.setByte(6, peli.getEstrellas());
            ps.setString(7, peli.getDirector());

            registros = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally{
            try {
                close(ps);
                close(conn);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            
        }
       return registros;

    }
        
}
