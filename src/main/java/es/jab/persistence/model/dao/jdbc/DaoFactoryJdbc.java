package es.jab.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.TemaDao;
import es.jab.persistence.model.dao.ValoracionDao;
import es.jab.persistence.model.entities.Tema;

public class DaoFactoryJdbc extends DaoFactory {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/miwjee";

    private static final String USER = "root";

    private static final String PASS = "";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(0)) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            LogManager.getLogger(DaoFactoryJdbc.class).error(
                    "Problemas con el driver: " + e.getMessage());
        } catch (SQLException e) {
            LogManager.getLogger(DaoFactoryJdbc.class).error(
                    "Problemas con la BD: " + e.getMessage());
        }
        return connection;
    }

    public static void dropAndCreateTables() {
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(String.format(DROP_TABLE, Tema.TABLE));
            statement.executeUpdate(TemaDaoJdbc.sqlToCreateTable());
        } catch (SQLException e) {
            LogManager.getLogger(DaoFactoryJdbc.class).error("Drop tables: " + e.getMessage());
        }
    }
    
    @Override
    public TemaDao getTemaDao() {
        return new TemaDaoJdbc();
    }

	@Override
	public ValoracionDao getValoracionDao() {
		return null;
	}

}
