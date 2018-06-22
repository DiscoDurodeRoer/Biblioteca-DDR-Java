package es.discoduroderoer.clases.bd;

public class ConexionSQLite extends ConexionDB {

    public ConexionSQLite(String ruta) {
        super("org.sqlite.JDBC", "jdbc:sqlite:" + ruta);
    }
}
