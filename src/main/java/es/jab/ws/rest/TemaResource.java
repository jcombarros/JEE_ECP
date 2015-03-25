package es.jab.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
		 return null;
		 
	 }
	 
	@PUT
    @Consumes(MediaType.APPLICATION_XML)
	 public Response update(Tema entity) {
		 return null;
		 
	 }
	 
	@DELETE
    @Path("/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	 public Response deleteById(@PathParam("id") int id) {
		 return null;
		 
	 }
	 
	@GET
    @Produces(MediaType.APPLICATION_XML)
	 public List<Tema> findAll() {
		 return null;
		 
	 }

}
