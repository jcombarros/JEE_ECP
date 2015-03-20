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
	        	TemasView temasView = new TemasView();
	        	
	        	String temaString = request.getParameter("temaId");
	        	if (temaString != null && !temaString.isEmpty()){
	        		try{
			        	Integer temaId = Integer.valueOf(request.getParameter("temaId"));
		        		Tema tema = temasView.recuperarTemaPorId(temaId);
		        		if(tema != null){
		        			temasView.setTema(tema);
		        		}
	        		}
	        		catch(NumberFormatException e){
	        			temasView.setMensaje("Seleccione un tema válido");
	        		}
	        	}
	        	request.setAttribute(action, temasView);
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
	        	TemasView temasView = new TemasView();
	        	
	        	String temaString = request.getParameter("temaId");
	        	if (temaString != null && !temaString.isEmpty()){
	        		Integer temaId = new Integer(-1);
	        		try{
			        	temaId = Integer.valueOf(temaString);
			        	Valoracion valoracion = new Valoracion();
			        	valoracion.setTema(temasView.recuperarTemaPorId(temaId.intValue()));
			        	valoracion.setRespuesta(Integer.valueOf(request.getParameter("respuesta")));
			        	valoracion.setNivelEstudios(NivelEstudios.valueOf(request.getParameter("nivelEstudios")));
			        	
			        	temasView.setValoracion(valoracion);		        	
			            request.setAttribute(action, temasView);
			            view = temasView.process();
	        		}
	        		catch(NumberFormatException e){
	        			temasView.setMensaje("Seleccione un tema válido");
			        	request.setAttribute(action, temasView);
			            view = action;
	        		}
	        	}
	        	else{
        			temasView.setMensaje("Debe seleccionar un tema");
	        		request.setAttribute(action, temasView);
		            view = action;
	        	}
	        	
	            break;
	        default:
	            view = "home";
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp").forward(request, response);
	}

}
