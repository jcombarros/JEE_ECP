package es.jab.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.jpa.DaoFactoryJpa;
import es.jab.persistence.model.entities.Valoracion;

@Path("/valoraciones")
public class ValoracionResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response create(Valoracion entity) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        DaoFactory.getInstance().getValoracionDao().create(entity);
        LogManager.getLogger(Valoracion.class).info("POST/ valoraciones:" + entity);
		return Response.ok(entity).build();
		 
	 }
	 
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
	 public Valoracion read(int id) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
		Valoracion entity = DaoFactory.getInstance().getValoracionDao().read(id);
        if (entity == null) {
            throw new NotFoundException();
        } else {
        	LogManager.getLogger(Valoracion.class).info("GET/ valoraciones/(id):" + entity);
            return entity;
        }
		 
	 }
	 
	@PUT
    @Consumes(MediaType.APPLICATION_XML)
	 public Response update(Valoracion entity) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        DaoFactory.getInstance().getValoracionDao().update(entity);
        LogManager.getLogger(Valoracion.class).info("PUT/ valoraciones:" + entity);
		return Response.ok(entity).build();
		 
	 }
	 
	@DELETE
    @Path("/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	 public Response deleteById(int id) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        DaoFactory.getInstance().getValoracionDao().deleteById(id);
        
        Valoracion entity = DaoFactory.getInstance().getValoracionDao().read(id);
        if (entity != null) {
            throw new InternalServerErrorException();
        } else {
        	LogManager.getLogger(Valoracion.class).info("DELETE/ valoraciones/(id):" + entity);
        	return Response.ok(entity).build();
        }
		 
	 }
	 
	@GET
    @Produces(MediaType.APPLICATION_XML)
	 public List<Valoracion> findAll() {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        List<Valoracion> entities = DaoFactory.getInstance().getValoracionDao().findAll();
    	LogManager.getLogger(Valoracion.class).info("GET/ valoraciones:" + entities);
        return entities;
		 
	 }
	 
	@DELETE
    @Path("/{id}" + "/byTema")
	@Consumes(MediaType.APPLICATION_XML)
	 public Response deleteByTema(int id){
		 return null;
	 }
	 
	@GET
	@Path("byTema")
    @Produces(MediaType.APPLICATION_XML)
	 public List<Valoracion> getByTema(int id){
		 return null;
	 }

}
