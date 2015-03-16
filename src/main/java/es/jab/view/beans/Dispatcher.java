package es.jab.view.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		        	Integer temaId = Integer.valueOf(request.getParameter("temaId"));
		        	if(temaId != null){
		        		temaView.addTema(temaId);
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
	}

}
