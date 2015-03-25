package es.jab.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.jab.persistence.model.entities.Valoracion;

@Path("/valoraciones")
public class ValoracionResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response create(Valoracion entity) {
		 return null;
		 
	 }
	 
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
	 public Valoracion read(int id) {
		 return null;
		 
	 }
	 
	@PUT
    @Consumes(MediaType.APPLICATION_XML)
	 public Response update(Valoracion entity) {
		 return null;
		 
	 }
	 
	@DELETE
    @Path("/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	 public Response deleteById(int id) {
		 return null;
		 
	 }
	 
	@GET
    @Produces(MediaType.APPLICATION_XML)
	 public List<Valoracion> findAll() {
		 return null;
		 
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
