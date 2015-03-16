package es.jab.view.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;
import es.jab.persistence.model.utils.NivelEstudios;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet("/Valoraciones/*")
public class Dispatcher extends HttpServlet {
	
	private static String PATH_ROOT_VIEW = "/jsp/";
	
	private static final long serialVersionUID = 1L;
       
    public Dispatcher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);

        String view;
        

        switch (action) {
	        case "temas":
	        	TemaView temaView = new TemaView();
	        	
	        	String temaString = request.getParameter("temaId");
	        	if (temaString != null && !temaString.isEmpty()){
	        		try{
			        	Integer temaId = Integer.valueOf(request.getParameter("temaId"));
		        		Tema tema = temaView.recuperarTemaPorId(temaId);
		        		if(tema != null){
		        			temaView.setTema(tema);
		        		}
	        		}
	        		catch(NumberFormatException e){
	        			temaView.setMensaje("Seleccione un tema válido");
	        		}
	        	}
	        	request.setAttribute(action, temaView);
	            view = action;
	            break;
	        default:
	            view = "home";
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo().substring(1);

        String view;
        
        switch (action) {
	        case "temas":
	        	TemaView temaView = new TemaView();
	        	
	        	String temaString = request.getParameter("temaId");
	        	if (temaString != null && !temaString.isEmpty()){
	        		Integer temaId = new Integer(-1);
	        		try{
			        	temaId = Integer.valueOf(temaString);
			        	Valoracion valoracion = new Valoracion();
			        	valoracion.setTema(temaView.recuperarTemaPorId(temaId.intValue()));
			        	valoracion.setRespuesta(Integer.valueOf(request.getParameter("respuesta")));
			        	valoracion.setNivelEstudios(NivelEstudios.valueOf(request.getParameter("nivelEstudios")));
			        	
			        	temaView.setValoracion(valoracion);		        	
			            request.setAttribute(action, temaView);
			            view = temaView.process();
	        		}
	        		catch(NumberFormatException e){
	        			temaView.setMensaje("Seleccione un tema válido");
			        	request.setAttribute(action, temaView);
			            view = action;
	        		}
	        	}
	        	else{
        			temaView.setMensaje("Debe seleccionar un tema");
	        		request.setAttribute(action, temaView);
		            view = action;
	        	}
	        	
	            break;
	        default:
	            view = "home";
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp").forward(request, response);
	}

}
