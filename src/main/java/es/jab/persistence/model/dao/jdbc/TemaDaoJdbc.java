package es.jab.persistence.model.dao.jdbc;

import es.jab.persistence.model.entities.Tema;

public class TemaDaoJdbc {
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
            + "%s VARCHAR(255) PRIMARY KEY (%s))";
	
	public static String sqlToCreateTable() {
        return String
                .format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.NOMBRE, Tema.PREGUNTA, Tema.ID);
    }

}
