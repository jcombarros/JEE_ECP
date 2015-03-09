package es.jab.persistence.model.dao;

public abstract class DaoFactory {
    private static DaoFactory factory = null;

    public static DaoFactory getInstance() {
    	assert factory != null;
        return factory;
    }
    
    public static void setDaoFactory(DaoFactory daoFactory){
    	factory = daoFactory;
    }

    public abstract TemaDao getTemaDao();

    public abstract ValoracionDao getValoracionDao();

}