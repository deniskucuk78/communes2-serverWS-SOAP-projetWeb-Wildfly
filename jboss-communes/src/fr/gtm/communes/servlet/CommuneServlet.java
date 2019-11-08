package fr.gtm.communes.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.communes.entities.Commune;
import fr.gtm.communes.service.CommuneServiceRemote;


/**
 * Servlet implementation class CommuneServlet
 */
@WebServlet("/CommuneServlet")
public class CommuneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private CommuneServiceRemote service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp = request.getParameter("cp");
		String page = "";
		if(cp==null || cp.isEmpty()) {
			page = "/index.jsp";
		}else {
			List<Commune> communes = service.getCommunesByCodePostalLike(cp);
			request.setAttribute("communes", communes);
			request.setAttribute("titre", "Communes par code postal "+cp);
			page = "/show-communes.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
