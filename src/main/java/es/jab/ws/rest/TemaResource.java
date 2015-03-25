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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.jpa.DaoFactoryJpa;
import es.jab.persistence.model.entities.Tema;

@Path("/temas")
public class TemaResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	 public Response create(Tema entity) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        DaoFactory.getInstance().getTemaDao().create(entity);
        LogManager.getLogger(Tema.class).info("POST/ temas:" + entity);
		return Response.ok(entity).build();
	 }
	 
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
	 public Tema read(@PathParam("id") int id) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        Tema entity = DaoFactory.getInstance().getTemaDao().read(id);
        if (entity == null) {
            throw new NotFoundException();
        } else {
        	LogManager.getLogger(Tema.class).info("@GET/ temas/(id):" + entity);
            return entity;
        }
		 
	 }
	 
	@PUT
    @Consumes(MediaType.APPLICATION_XML)
	 public Response update(Tema entity) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        DaoFactory.getInstance().getTemaDao().update(entity);
        LogManager.getLogger(Tema.class).info("PUT/ temas:" + entity);
		return Response.ok(entity).build();
		 
	 }
	 
	@DELETE
    @Path("/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	 public Response deleteById(@PathParam("id") int id) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
        DaoFactory.getInstance().getTemaDao().deleteById(id);
        
        Tema entity = DaoFactory.getInstance().getTemaDao().read(id);
        if (entity != null) {
            throw new InternalServerErrorException();
        } else {
        	LogManager.getLogger(Tema.class).info("@GET/ temas/(id):" + entity);
        	return Response.ok(entity).build();
        }
		 
	 }
	 
	@GET
    @Produces(MediaType.APPLICATION_XML)
	 public List<Tema> findAll() {
		 return null;
		 
	 }

}
