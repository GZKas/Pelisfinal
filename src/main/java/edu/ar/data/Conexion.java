package edu.ar.data;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

        private final static String JDBC_URL = 
        "jdbc:mysql://127.0.0.1:3306/peliculas_web?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyReference";

    private final static String JDBC_USER = "root";
    //Ingresan su contraseña para acceder a la base de datos
    private static String JDBC_PASS = "12345678";

    //DAta Source
    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASS);
        ds.setInitialSize(100);
        return ds;
    }

    public static Connection getConexion() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace(System.out);
        }
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close(Statement st) throws SQLException{
        st.close();
    }
    public static void close(Connection cn) throws SQLException{
        cn.close();
    }

}
