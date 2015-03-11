package es.jab.persistence.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jab.persistence.model.dao.TemaDao;
import es.jab.persistence.model.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao{
	
    private Logger log = LogManager.getLogger(TemaDaoJdbc.class);
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
            + "%s VARCHAR(255) PRIMARY KEY (%s))";
	
	public static String sqlToCreateTable() {
        return String
                .format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.NOMBRE, Tema.PREGUNTA, Tema.ID);
    }

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s) VALUES ('%s','%s')";
	
	@Override
	public void create(Tema entity) {
        this.updateSql(String.format(SQL_INSERT, Tema.TABLE, Tema.NOMBRE, Tema.PREGUNTA,
        		entity.getNombre(), entity.getPregunta()));
        entity.setId(this.autoId());
	}

	@Override
    public Tema read(Integer id) {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Tema.TABLE, id));
        return this.create(resultSet);
    }

	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Tema create(ResultSet resultSet) {
        Tema tema;
        try {
            if (resultSet != null && resultSet.next()) {
                tema = new Tema(resultSet.getString(Tema.NOMBRE), resultSet.getString(Tema.PREGUNTA));
                tema.setId(resultSet.getInt(Tema.ID));
                
                return tema;
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        return null;
    }

}
